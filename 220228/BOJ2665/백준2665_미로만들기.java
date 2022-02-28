import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 백준2665_미로만들기 {
	/*
	 * 사방탐색 후
	 * 다음 칸이 흰색인 경우와 방문하지 않은 경우 add
	 * 그리고 다음 칸이 검은 칸인 경우, 지나지 않는 경우와 흰색칸으로 변경하여 지나는 경우로 나누
	 * */
	
	static int[][] map;
	static int N;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static class Point implements Comparable<Point>{
		int x, y;
		int weight;
		public Point(int x,int y,int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		@Override
		public int compareTo(Point o) {
			return this.weight-o.weight;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1)); 
			}
		}
	
		
		
		
		int ans = dijkstra();
		
		System.out.println(ans);
		
	}
	public static int dijkstra() {
		
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		
		int min = Integer.MAX_VALUE;
		pq.add(new Point(0,0,0));
		
		while(!pq.isEmpty()) {
			
			
			Point current = pq.poll();
			
			if(visited[current.x][current.y]) continue;
			
			if(current.x==N-1&&current.y==N-1) return current.weight;
			
			visited[current.x][current.y] = true;
			
			for(int d=0;d<4;d++) {
				int ni = current.x + di[d];
				int nj = current.y + dj[d];
				
				if(ni<0||nj<0||ni>=N||nj>=N) continue;
				
				if(map[ni][nj]==1) {
					pq.add(new Point(ni,nj,current.weight));
				}else if (map[ni][nj]==0) {
					pq.add(new Point(ni,nj,current.weight+1));
					
				}
				
			}
			
			
		}
		
		
		return 0;
	}

}
