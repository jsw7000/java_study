import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준5972_택배배송 {

	/*
	 * N개의 헛간. M개의 양방향 길
	 * Node -> idx,cost인데 양방향이니까 from,to둘 다 넣어주기
	 * 
	 * */
	static class Road implements Comparable<Road>{ // Node
		
		int idx,cost; //목적지와 비용
		
		public Road(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}


		@Override
		public int compareTo(Road o) {
			return this.cost-o.cost;
		}
	}
	
	static int N, M;
	static ArrayList<List<Road>> adjList; //인접리스트
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList<>();
		
		for(int i=0;i<N+1;i++) {
			adjList.add(new ArrayList<Road>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//양방향 처리
			adjList.get(from).add(new Road(to,cost));
			adjList.get(to).add(new Road(from,cost));
			
		}
		
		int ans = Dijkstra();
		
		System.out.println(ans);
		
	}
	public static int Dijkstra() {
		
		PriorityQueue<Road> pq = new PriorityQueue<>();
		
		int[] D = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		//distance 배열 초기화
		Arrays.fill(D, Integer.MAX_VALUE);
		
		//시작점 1
		pq.add(new Road(1,0));
		D[1]=0;

		
		while(!pq.isEmpty()) {
			
			Road current = pq.poll();
			
			if(visited[current.idx]||D[current.idx]<current.cost) continue;
			
			if(current.idx==N) break;
			
			visited[current.idx] = true;
			
			for(Road nr : adjList.get(current.idx)) {
				
				if(D[nr.idx]>D[current.idx]+nr.cost) {
					D[nr.idx] = current.cost+nr.cost;
					pq.add(new Road(nr.idx,D[nr.idx]));
				}
				
				
			}
			
			
		}
		
		
		return D[N];
		
		
	}

}
