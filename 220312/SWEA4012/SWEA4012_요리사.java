import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012_요리사 {

	static int N;
	static int[][] arr;
	static int[] usedA;
	static int[] usedB;
	static boolean[] check;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			usedA = new int[N/2];
			usedB = new int[N/2];
			check = new boolean[N];
			min = Integer.MAX_VALUE;
			StringTokenizer st = null;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combi(0,0);
			System.out.println("#"+tc+" "+min);
			
		}
		
	}
	public static void combi(int idx,int cnt) {
		if(cnt==N/2) {
			
			int a=0;
			int b=0;
			for(int i=0;i<N;i++) {
				if(check[i]) usedA[a++]=i;
				else usedB[b++]=i;
			}
			
			int dishA = 0;
			int dishB = 0;
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<N/2;j++) {
					if(i==j) continue;
					dishA = dishA + arr[usedA[i]][usedA[j]];
				
				}
			}
			
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<N/2;j++) {
					if(i==j) continue;
					dishB = dishB + arr[usedB[i]][usedB[j]];
				
				}
			}
			int abs = Math.abs(dishA-dishB);
			min = min>abs?abs:min;
			
			return;
			
			
		}
		
		for(int i=idx;i<N;i++) {
			check[i] = true;
			combi(i+1,cnt+1);
			check[i] = false;
			
		}
		
	}

}
