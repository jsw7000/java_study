package day220121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준15683_감시 {
/*
 * 1~5 : cctv
 * 6 : 벽
 * 
 * */
	static int[] cctvDir = {0,4,2,4,4,1}; //cctv가 볼 수 있는 방향의 가짓 수 
	static class CCTV{
		int x,y; //cctv의 위치 좌
		int num; //cctv의 종류
//		int[] dir;
		
		public CCTV(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}
		
		
	}
	static int N,M;
	static int[] di = {0,-1,0,1}; //좌,상,우,하
	static int[] dj = {-1,0,1,0};
	static int[][] map;
	static ArrayList<CCTV> list = new ArrayList<>();
	static int min;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0&&map[i][j]!=6) {
					list.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
//		print();
		dfs(0);
		
		System.out.println(min);
		
	}
	public static void dfs(int cnt) {
		
		if(cnt==list.size()) {
			int ans = caculate(map);
			min = min>ans?ans:min;
			return;
		}
		
		int[][] copy = new int[N][M];
		
		CCTV current = list.get(cnt); 
		
		for(int t=0;t<cctvDir[current.num];t++) {
			copy = copyMap(map);
			
			if(current.num==1) {
				monitor(current,t);
			}else if(current.num==2) {
				monitor(current,t);
				monitor(current,t+2);
			}else if(current.num==3) {
				monitor(current,t);
				monitor(current,t+1);
			}else if(current.num==4) {
				monitor(current,t);
				monitor(current,t+1);
				monitor(current,t+2);
			}else if(current.num==5) {
				monitor(current,t);
				monitor(current,t+1);
				monitor(current,t+2);
				monitor(current,t+3);
			}
			
			dfs(cnt+1);
			map = copyMap(copy);
			
		}
		

		
	}
	public static int[][] copyMap(int[][] map){
		
		int[][] copy = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
		
	}
	public static void monitor(CCTV cctv, int dir) {
		
		dir%=4;
		
		
		
		int nowi = cctv.x,nowj= cctv.y;
		int ni = cctv.x,nj = cctv.y;
		while(true) {
			ni = nowi + di[dir];
			nj = nowj + dj[dir];
			if(ni>=N||nj>=M||ni<0||nj<0||map[ni][nj]==6) break;
			
			nowi = ni;
			nowj = nj;
			
			if((map[nowi][nowj]>=1&&map[nowi][nowj]<=5)||map[nowi][nowj]==7) continue;
			//	방향대로 직진ㄴ & 7로 체크
			// 범위를 넘어가거나 벽이 아니어야 함
			// 만약 cctv가 나온다면 그대로 continue
			
			map[nowi][nowj] = 7;
			
		}
		
//		print();

		
	}
	public static int caculate(int[][] map) {
		int cnt =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		
		return cnt;
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		System.out.println("=============");
	}

}
