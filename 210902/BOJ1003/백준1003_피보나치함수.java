import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준1003_피보나치함수 {

	/*
	 * int[][] dp; // 0 : 0의 개수, 1 : 1의 개수
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] DP = new int[41][2];
		DP[0][0] = 1;
		DP[0][1] = 0;
		DP[1][1] = 1; // 0과 1의 개수 카운트
		DP[1][0] = 0;
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			

			for (int j = 2; j <= N; j++) {
				DP[j][0] = DP[j-1][0]+DP[j-2][0];
				DP[j][1] = DP[j-1][1]+DP[j-2][1];
			}
			
			sb.append(DP[N][0]+" "+DP[N][1]+"\n");
		}
		
		System.out.print(sb);

	}

}
