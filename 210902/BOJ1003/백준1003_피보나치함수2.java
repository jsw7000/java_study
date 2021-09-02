import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준1003_피보나치함수2 {

	/*
	 * int[][] dp; // 0 : 0의 개수, 1 : 1의 개수
	 */
	static int[][] DP = new int[41][2];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		DP[0][0] = 1;
		DP[0][1] = 0;
		DP[1][1] = 1; // 0과 1의 개수 카운트
		DP[1][0] = 0;
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			fibo(N);
			sb.append(DP[N][0]+" "+DP[N][1]+"\n");
		}
		
		System.out.print(sb);

	}
	
	public static int[] fibo(int N) {
		if(N>=2&& (DP[N][0]==0 || DP[N][1]==0)) {
				DP[N][0] = fibo(N-1)[0]+fibo(N-2)[0];
				DP[N][1] = fibo(N-1)[1]+fibo(N-2)[1];
		}
		
		return DP[N];
	}

}
