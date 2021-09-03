package day210903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준9184_신나는함수실행 {
	/*
	 * a,b,c <=0인경우엔 어차피 무조건 1리턴이니까 값을 넣어둘 필요가 없을거같은데
	 * 
	 * 다 20보다 큰경우
	 */
	static int[][][] DP = new int[21][21][21];

	public static void main(String[] args) throws IOException {

		DP[0][0][0] = 1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		;
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1)
				break;

			int result = w(a, b, c);
			sb.append("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");

		}

		System.out.print(sb);

	}

	public static int w(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0) {
			return DP[0][0][0];
		}
		
		if (a > 20 || b > 20 || c > 20) {

			if (DP[20][20][20] == 0) {
				DP[20][20][20] = w(20, 20, 20);
			}

			return DP[20][20][20];
		}

		if (DP[a][b][c] == 0) {
			if (a < b && b < c) {

				DP[a][b][c - 1] = w(a, b, c - 1);
				DP[a][b - 1][c - 1] = w(a, b - 1, c - 1);
				DP[a][b - 1][c] = w(a, b - 1, c);

				return DP[a][b][c - 1] + DP[a][b - 1][c - 1] - DP[a][b - 1][c];
			} else {

				DP[a - 1][b][c] = w(a - 1, b, c);
				DP[a - 1][b - 1][c] = w(a - 1, b - 1, c);
				DP[a - 1][b][c - 1] = w(a - 1, b, c - 1);
				DP[a - 1][b - 1][c - 1] = w(a - 1, b - 1, c - 1);
				return DP[a - 1][b][c] + DP[a - 1][b - 1][c] + DP[a - 1][b][c - 1] - DP[a - 1][b - 1][c - 1];
			}
		}

		return DP[a][b][c];
	}

}
