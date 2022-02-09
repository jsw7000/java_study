import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준1238_파티 {

	/*
	 * 일반 다익스트라랑 동일한데 1~N번을 각각 시작점으로 두고 다익스트라를 한다는게 다름
	 * 최단시간 학생들 중 max를 구한다.
	 * */
	
	static int N,M;
	static ArrayList<List<Node>> adjList,rvAdjList; 
	
	static class Node implements Comparable<Node>{
		int idx, cost;
		
		Node(int idx, int cost){
			this.idx=idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()); //도착
		int max = Integer.MIN_VALUE; // 최대 시간
		
		adjList = new ArrayList<>();
		rvAdjList = new ArrayList<>();
		
		//리스트 할당
		for(int i=0;i<N+1;i++) {
			adjList.add(new ArrayList<Node>());
			rvAdjList.add(new ArrayList<Node>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(new Node(to,cost)); //집->X
			rvAdjList.get(from).add(new Node(to,cost)); //X->집
			
			
		}
		
		for(int i=1;i<N+1;i++) {
			
			int sum = 0;
			sum = sum + dijkstra(adjList,X, i);
			sum = sum + dijkstra(rvAdjList,i, X);
			max = max <sum ? sum : max;
			
		}
		
		System.out.println(max);

	}
	public static int dijkstra(ArrayList<List<Node>> list,int start,int end) {
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] D = new int[N+1];
		
		//distance 배열 초기화
		Arrays.fill(D, Integer.MAX_VALUE);
		
		pq.add(new Node(start,0));
		D[start]=0;
		
		while(!pq.isEmpty()) {
			
			Node current = pq.poll();
			
			if(D[current.idx]<current.cost) continue;
			
			if(current.idx == end) break;
			

			
			for(Node next : list.get(current.idx)) {
				if(D[next.idx]>D[current.idx]+next.cost) {
					D[next.idx] = D[current.idx] + next.cost;
					pq.add(new Node(next.idx,D[next.idx]));
				}
			}
			
		}
		
		
		return D[end];
		
		
		
	}

}
