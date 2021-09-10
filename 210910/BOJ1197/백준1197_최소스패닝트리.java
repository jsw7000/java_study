import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준1197_최소스패닝트리 {
	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static int V, E;
	public static LinkedList<ArrayList<Edge>> adjList;

	public static void main(String[] args) throws IOException {
		/*
		 * class Edge{int to,long cost}
		 * 
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjList = new LinkedList<>();

		for (int i = 0; i < V + 1; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			adjList.get(A).add(new Edge(B, C));
			adjList.get(B).add(new Edge(A, C));
		}

		long min = process(1, 0);
		System.out.println(min);
	}

	public static long process(int start, int cost) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[V + 1];
		long result = 0;
		int cnt = 0;

		pq.add(new Edge(start, cost));

		while (!pq.isEmpty()) {
			// pq에 담긴 애를 뺀다
			Edge current = pq.poll();

			// 얘가 방문된 지점인지 아닌지 체크
			if (visited[current.to])
				continue;
			visited[current.to] = true;// 아니라면 true
			result += current.cost;// 그리고 최소값 누적하기
			// ++cnt==N이라면 탈출!
			// 현재 정점의 주변 애들 둘러보기
			for (Edge next : adjList.get(current.to)) {
				if (visited[next.to])
					continue;
				pq.add(new Edge(next.to, next.cost));
			}
			if (++cnt == V)
				break;
		}

		return result;
	}

}