import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준17144_미세먼지안녕 {

	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int R,C,T;
	static int[][] map;
	static int[] di = {0,-1,0,1}; //우,상,좌,하
	static int[] dj = {1,0,-1,0};
	static ArrayList<Point> list; //공기청정기의 위치를 저장하는 리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		list = new ArrayList<>();
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					list.add(new Point(i,j));
				}
			}
		}
		
		for(int t=0;t<T;t++) { //t초 만큼 반복
			// 미세먼지 확산
			spreadDust();
			// 공기청정기 작동
			cleanAir();
		}
		
		int ans = countDust();
		System.out.println(ans);
		
	}
	public static void spreadDust() {
		int[][] temp = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==-1) continue;
				int cnt = 0;
				for(int d=0;d<4;d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					
					if(ni<0||nj<0||ni>=R||nj>=C||map[ni][nj]==-1) continue;
					temp[ni][nj]+=Math.round(map[i][j]/5);
					cnt++;
				}
				map[i][j] = map[i][j]-map[i][j]/5*cnt;
				
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]+=temp[i][j];
			}
		}
	}
	public static void cleanAir() {
		
		//상
		int dir = 0;
		Point air = list.get(0);
		int x = air.x;
		int y = air.y;
		
		int[][] temp = deepCopy();
		temp[x][y]=0;
		
		while(true) {
			int ni = x + di[dir];
			int nj = y + dj[dir];
			
			if(ni<0||nj<0||ni>=R||nj>=C) {
				dir=(dir+1)%4;
				continue;
			}if(ni==air.x && nj==air.y) break;
			
			map[ni][nj]=temp[x][y];
			x=ni;
			y=nj;
		}

		//하
		dir = 0;
		air = list.get(1);
		x = air.x;
		y = air.y;
		temp[x][y]=0;
		
		while(true) {
			int ni = x + di[dir];
			int nj = y + dj[dir];
			
			if(ni<0||nj<0||ni>=R||nj>=C) {
				dir=(dir+3)%4;
				continue;
			}if(ni==air.x && nj==air.y) break;
			
			map[ni][nj]=temp[x][y];
			x=ni;
			y=nj;
		}
		
	}
	public static int countDust() {
		int cnt = 0;
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==-1) continue;
				cnt += map[i][j];
				
			}
		}
		return cnt;
	}
	public static int[][] deepCopy(){
		int[][] copy = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				copy[i][j]=map[i][j];
				if(copy[i][j]==-1) copy[i][j]=0;
			}
		}
		
		return copy;
	}
	

}
