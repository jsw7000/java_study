import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준14499_주사위굴리기 {

	static int N, M ;
	static int[][] map;
	static int[] di = {0,0,-1,1};//동,서,북,남
	static int[] dj = {1,-1,0,0};
	static int[] dice; //주사위 6면
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dice = new int[7]; // 1: 바닥면, 6: 상단면
		
		int[] order = new int[K]; // 명령 배열
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<K;i++) {
			int d = order[i];
			int ni = x + di[d-1];
			int nj = y + dj[d-1];
			
			if(ni<0||nj<0||ni>=N||nj>=M) continue;
			
			//주사위 굴리기
			rollDice(d);
			
			//map 바닥과 주사위 바닥면 검사
			if(map[ni][nj]==0) {
				map[ni][nj] = dice[1];
			}else if(map[ni][nj]!=0) {
				dice[1] = map[ni][nj];
				map[ni][nj] = 0;
			}
			
			x = ni;
			y = nj;
			
			sb.append(dice[6]+"\n");
			
		}
		
		System.out.println(sb.toString());
		
		
	}
	
	public static void rollDice(int d) {
		
		int[] temp = copyDice();
		
		if(d==1) {
			dice[1] = temp[3];
			dice[4] = temp[1];
			dice[6] = temp[4];
			dice[3] = temp[6];
		}else if(d==2) {
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[6] = temp[3];
			dice[4] = temp[6];
		}else if(d==3) {
			dice[2] = temp[6];
			dice[1] = temp[2];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}else if(d==4) {
			dice[2] = temp[1];
			dice[1] = temp[5];
			dice[5] = temp[6];
			dice[6] = temp[2];
		}
		
		
	}
	
	
	public static int[] copyDice() {
		int[] temp = new int[7];
		for(int i=0;i<7;i++) {
			temp[i] = dice[i];
		}
		return temp;
	}

}
