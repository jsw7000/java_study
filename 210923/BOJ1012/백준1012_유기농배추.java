import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1012_유기농배추 {

	static int M,N,K;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int ans;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Point> list;
	static class Point{
		int x,y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			list = new ArrayList<Point>();
			ans = 0;
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				map[x][y]=1;
				list.add(new Point(x,y));
			}
			
			for(int k=0;k<list.size();k++) {
				Point point = list.get(k);
				if(map[point.x][point.y]!=1||visited[point.x][point.y]) continue;
				bfs(point.x,point.y);
			}
			
			System.out.println(ans);
		}
	}
	public static void bfs(int x,int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x,y));
		ans++;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			if(visited[current.x][current.y]) continue;
			
			visited[current.x][current.y] = true;
			
			for(int d=0;d<4;d++) {
				int ni = current.x + di[d];
				int nj = current.y + dj[d];
				
				if(ni<0||nj<0||ni>=N||nj>=M||map[ni][nj]==0||visited[ni][nj]) continue;
				
				queue.add(new Point(ni,nj));
			}
		}
	}
}
