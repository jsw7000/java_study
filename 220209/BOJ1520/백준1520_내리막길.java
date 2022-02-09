import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1520_내리막길 {

	static int M,N;//세로,가로
	static int[][] map;
	static int[][] DP;
	static int[] di = {-1,1,0,0};//상,하,좌,우
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		DP = new int[M][N];
		
		for(int i=0;i<M;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			Arrays.fill(DP[i], -1);
		}
		
		int  ans = dfs(0,0);
		
		System.out.println(ans);
		
	}
	public static int dfs(int x, int y) {
		
		if(x==M-1&&y==N-1) {
			return 1;
		}else if(DP[x][y]!=-1) {
			return DP[x][y];
		}else {
			
			DP[x][y]=0;
			
			
			for(int d=0;d<4;d++) {
				int ni = x+di[d];
				int nj = y+dj[d];
				
				if(ni<0||nj<0||ni>=M||nj>=N) continue;
				
				if(map[x][y]>map[ni][nj]) {
					DP[x][y]+=dfs(ni,nj);
					
//					print();
				}
				
				
			}
			
		}
		
		
		
		
		return DP[x][y];
		
		
	}
//	public static void print() {
//		
//		for(int i=0;i<M;i++) {
//			System.out.println(Arrays.toString(DP[i]));
//		}
//		
//		System.out.println("============");
//	}

}
