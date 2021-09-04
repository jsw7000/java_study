import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준1753_최단경로 {
	// 다익스트라 알고리즘
	// MST는 어떤 지점에서 시작해도 상관XX
	// 다익스트라는 시작하는 지점에 따라 최단경로 값 달라짐!

	static int V, E, K; // 정점의 개수, 간선의 개수, 시작 정
	static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
	static int[] distance;
	static boolean[] visited;
	static class Node implements Comparable<Node>{
		int idx;
		int weight;

		public Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
	
		distance = new int[V+1];
		visited = new boolean[V+1];
		
		for(int i=0;i<V+1;i++) {
			adj.add(new ArrayList<>());
			distance[i] = Integer.MAX_VALUE; // 다익스트라 초기화
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adj.get(from).add(new Node(to,weight));
		}
		
		
		dikstra();
		
		for(int i=1;i<distance.length;i++) {
			if(distance[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	
	public static void dikstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited[K] = true;
		
		pq.offer(new Node(K,0));
		
		distance[K] =0;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			if(distance[current.idx]<current.weight) continue;
			
			for(int i=0;i<adj.get(current.idx).size();i++) {
				Node node = adj.get(current.idx).get(i);
				
				if(distance[node.idx]>current.weight + node.weight) {
					distance[node.idx] = current.weight + node.weight;
					
					pq.offer(new Node(node.idx,distance[node.idx]));
				}
			}
			
		}
	}
}
