import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준1916_최소비용구하기 {

	/*
	 * N개의 도시
	 * 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스
	 * A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화!
	 * A번째 도시에서 B번째 도시까지 가는데 드는 최소 비용을 출력하라
	 * 도시의 번호는 1부터 N까지 이다.
	 * 
	 * 
	 * */
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node arg0) {
			return this.cost-arg0.cost;
		}
		
	}
	static int N,M;
	static ArrayList<List<Node>> adjList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adjList = new ArrayList<List<Node>>();
		
		
		StringTokenizer st = null;
		
		for(int i=0;i<N+1;i++) {
			adjList.add(new ArrayList<>());
		}
		
		//버스 노선에 관한 정보
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList.get(from).add(new Node(to,cost));
			
		}
		
		//출발점 도시 번호, 도착점 도시 번호
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int result = dijkstra(start,end);
		
		
		System.out.println(result);
		
	}
	
	public static int dijkstra(int start,int end) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] D = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(D, Integer.MAX_VALUE);
		
		D[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			Node current = pq.poll();
			
//			for(Node n:adjList.get(current.idx)) {
				if(D[current.idx]<current.cost) {
					continue;
				}
//			}
			
//			visited[current.idx] = true;
			if(current.idx == end) break;
			
			for(Node n:adjList.get(current.idx)) {
				if(D[n.idx]>current.cost+n.cost) {
					D[n.idx] = current.cost+n.cost;
					pq.add(new Node(n.idx,D[n.idx]));
				}
			}
			
		}
		
		
		return D[end];
	}

}
