package day220111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준14503_로봇청소기 {

	static int N,M;
	static int[][] map;
	static int[] di = {-1,0,1,0};//0:북,1:동,2:남,3:서
	static int[] dj = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken()); //현재 위치 r
		int c = Integer.parseInt(st.nextToken()); //현재 위치 c
		int d = Integer.parseInt(st.nextToken()); //현재 바라보는 방향

		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = startClean(r,c,d);
		System.out.println(ans);
		
	}
	
	public static int startClean(int r, int c, int d) {
		
		int cnt = 0;
		int nowi = r,nowj =c,nowd = d;
		int ni=nowi,nj=nowj;
		boolean flag = true;
		int checkCnt = 0; //네 방향 모두 돌았는지 체크하는 변수 
		
		
		while(flag) {
			nowi = ni;
			nowj = nj;
			if(map[nowi][nowj]==0) {
				map[nowi][nowj]=2;
				cnt++;
			}
			

			
			while(true) {
				if(checkCnt==4) {
					checkCnt=0;
					ni = nowi-di[nowd];
					nj = nowj-dj[nowd];
					
					if(map[ni][nj]==1) {
						flag = false;
						break;
					}else {
						nowi = ni;
						nowj = nj;
						
					}
				}
				
			
				
				nowd=(nowd+3)%4;
				ni = nowi+di[nowd];
				nj = nowj+dj[nowd];
				
				if(map[ni][nj]!=0) {
					checkCnt++;
					continue;
				}else {
					checkCnt=0;
					break;
				}
			}
		}
		return cnt;
		
		
		
	}

}
