package day220326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs
 * 탈주범이 있을 수 있는 위치의 개수를 계산
 * 
 * 1. 상: 1,2,5,6,하: 1,2,4,7, 좌:1,3,4,5 ,우:1,3,6,7
 * 2. 상: 1,2,5,6 하: 1,2,4,7, 좌:X , 우:X
 * 3. 상: X, 하: X, 좌: 1,3,4,5, 우: 1,3,6,7
 * 4 .상: 1,2,5,6, 하: X, 좌: X, 우: 1,3,6,7
 * 5. 상: X, 하: 1,2,4,7, 좌: X, 우: 1,3,6,7
 * 6. 상: X, 하: 1,2,4,7, 좌: 1,3,4,5, 우: X
 * 7. 상: 1,2,5,6, 하: X, 좌: 1,3,4,5, 우: X
 * */
public class SWEA1953_탈주범검거 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int[][] map;
	static int N,M,T;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int tc=1;tc<=TC;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = bfs(x,y);
			sb.append("#"+tc+" "+ans+"\n");
			
			
		}
		System.out.println(sb.toString());
		
	}
	public static int bfs(int x,int y) {
		
		int cnt = 0;
		int time = 0;
		
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new Point(x,y));
		
		//bfs
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			for(int s = 0 ; s<size;s++) {
				
				Point current = queue.poll();
				int cx = current.x;
				int cy = current.y;
				int cv = map[cx][cy];
				
				if(visited[cx][cy]) continue;
				
				visited[cx][cy] = true;
				cnt++;
				
				for(int d=0;d<4;d++) {
					
					int ni = cx + di[d];
					int nj = cy + dj[d];
					
					if(ni<0||nj<0||ni>=N||nj>=M||map[ni][nj]==0||visited[ni][nj]) continue;
					
					//탈주로 체크
					int nv = map[ni][nj];
					if(d==0) {
						if(cv==1||cv==2||cv==4||cv==7) {
							switch(nv) {
							case 1:
							case 2:
							case 5:
							case 6:
								queue.add(new Point(ni,nj));
								break;
							}
						}
					}else if(d==1) {
						if(cv==1||cv==2||cv==5||cv==6) {
							switch(nv) {
							case 1:
							case 2:
							case 4:
							case 7:
								queue.add(new Point(ni,nj));
								break;
							}
						}
						
					}else if(d==2) {
						if(cv==1||cv==3||cv==6||cv==7) {
							switch(nv) {
							case 1:
							case 3:
							case 4:
							case 5:
								queue.add(new Point(ni,nj));
								break;
							}
						}
						
					}else if(d==3) {
						if(cv==1||cv==3||cv==4||cv==5) {
							switch(nv) {
							case 1:
							case 3:
							case 6:
							case 7:
								queue.add(new Point(ni,nj));
								break;
							}
						}
						
					}
					
				}
				
			}
			
			time++;
			if(time==T) break;
		}
		
		
		return cnt;
		
	}
	

}
