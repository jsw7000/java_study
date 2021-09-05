package day210905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준1504_특정한최단경로 {

	/*
	 * 방향성이 없는 그래프가 주어짐 1번 정점->N번 정점으로 최단 거리로 이동 조건 : 임의로 주어진 두 정점은 반드시 통과해야 한다?..
	 * 
	 * 한 번 이동했던 정점은 물론, 한 번 이동했던 간선도 다시 이동 가능. 하지만 반드시 최단 경로로 이동해야 함 주어진 두 정점은 반드시
	 * 거치면서 최단 경로로 이동하는 프로그램
	 * 
	 * start는 무조건 1번 정점
	 * 
	 * 1->v1->v2->N 1->v2->v1->N
	 * 
	 * 
	 */

	static int N, E; // 정점의 개수, 간선의 개수
	static int v1, v2; // 반드시 거쳐야 하는 두 개의서로 다른 정점
	static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
	static int[] dist;
	static boolean[] visited;
	static int INF = 200000000;

	static class Node implements Comparable<Node> {
		int idx, weight;

		public Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node arg0) {
			return Integer.compare(this.weight, arg0.weight); // weight를 기준으로 정렬, 오름차순
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i <N+1; i++) {
			adjList.add(new ArrayList<Node>());
		}

		dist = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList.get(from).add(new Node(to, weight));
			adjList.get(to).add(new Node(from, weight));

		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);

		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);

		int ans = 0;
		if (res1 >= INF && res2 >= INF)
			ans = -1;
		else {
			ans = res1 < res2 ? res1 : res2;
		}
		System.out.println(ans);

	}

	public static int dijkstra(int start, int end) {
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Arrays.fill(dist, INF); // dist 배열 초기화
		Arrays.fill(visited, false); // visited 배열 초기화

		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node current = pq.poll();

			if(visited[current.idx]) continue;
			visited[current.idx] = true;

			for (Node next : adjList.get(current.idx)) {
				if (!visited[next.idx] && dist[next.idx] > dist[current.idx] + next.weight) {
					dist[next.idx] = dist[current.idx] + next.weight;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		return dist[end];
	}
}
