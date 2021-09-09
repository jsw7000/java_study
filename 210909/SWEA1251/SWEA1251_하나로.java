package day210908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_하나로 {
	static int N; // 섬의 개수
	static long[] xPoint;
	static long[] yPoint;

	static class Edge implements Comparable<Edge> {
		int to;
		long cost;

		public Edge(int to, long cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);

		}
	}

	static LinkedList<ArrayList<Edge>> adj; // 인접배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int TC = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			xPoint = new long[N];
			yPoint = new long[N];

			adj = new LinkedList<>();
			
			for(int i=0;i<N;i++) {
				adj.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xPoint[i] = Long.parseLong(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yPoint[i] = Long.parseLong(st.nextToken());
			}

			double E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {
					if (i != j) {
						long distance = (xPoint[i] - xPoint[j]) * (xPoint[i] - xPoint[j])
								+ (yPoint[i] - yPoint[j]) * (yPoint[i] - yPoint[j]);
						adj.get(i).add(new Edge(j, distance));
					}
				}
			}
			long result = mst(); 
			double ans = result*E;
			System.out.println("#"+tc+" "+Math.round(ans));
		}
	}

	public static long mst() {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[N];
		int cnt = 0;
		long result = 0;

		pq.offer(new Edge(0, 0));


		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			
            // 방문하지 않은 최소정점 찾기
			if (visited[current.to])
				continue;
                
			visited[current.to] = true;	// 방문처리
			result += current.cost; // 누적비용
			
			// cnt의 개수가 N이라면 break!
			if (++cnt == N)
				break;

			for (Edge next : adj.get(current.to)) {
				if (!visited[next.to]) {
					pq.add(next);
				}
			}

		}

		return result;
	}
}
