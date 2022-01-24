import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준18430_무기공학 {

	static int N,M;
	static int[][] map;
	static int max;
	static int[] di = {0,-1,0,1};//좌,상,우,하
	static int[] dj = {-1,0,1,0};//좌,상,우,하

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max = Integer.MIN_VALUE;
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0,visited);
		
		if(max==Integer.MIN_VALUE) System.out.println(0);
		else System.out.println(max);
		
	}
	public static void dfs(int x, int y,int sum,boolean[][] visited) {
		if(x==N&&y==0) {
			max=max<sum?sum:max;
			return;
		}

		max=max<sum?sum:max;
		
		for(int i=x;i<N;i++) {
			for(int j=y;j<M;j++) {
				
				if(visited[i][j]) continue;
				
				for(int d=0;d<4;d++) {
					boolean[][] copy = copyVisited(visited);
					//현재위치
					//날개들 2개까지 모두 체크해서 방문처리까지 하는
					if(isAvailable(i,j,d,visited)) {
						int tmp = sum + map[i][j]*2 + map[i+di[d]][j+dj[d]] + map[i+di[(d+1)%4]][j+dj[(d+1)%4]];
						
						
						copy[i][j] = copy[i+di[d]][j+dj[d]] = copy[i+di[(d+1)%4]][j+dj[(d+1)%4]] = true;
						
						if(j+1==M) dfs(i+1,0,tmp,copy);
						else dfs(i,j+1,tmp,copy);
						
					};
					
					
					
				}
			}
		}
		
		
	}
	public static boolean[][] copyVisited(boolean[][] visited){
		boolean[][] copy = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copy[i][j]=visited[i][j];
				}
		}
		
		return copy;
	}
	
	public static boolean isAvailable(int x, int y,int dir, boolean[][] visited) {
		
		int ni =x, nj = y;
		for(int d=0;d<2;d++) {
			ni = x + di[(dir+d)%4];
			nj = y + dj[(dir+d)%4];
			if(ni>=N||nj>=M||ni<0||nj<0||visited[ni][nj]) return false;
		}
		
		return true;
		
	}
	
	public static void print(boolean[][] visited) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
					if(visited[i][j]) System.out.print("O");
					else System.out.print("X");
//				System.out.println(visited[i][j]);
				}
			System.out.println();
		}
		
		System.out.println("=============");
	}

}
