package day210905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1932_정수삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][];

		for (int i = 1; i < N + 1; i++) {
			arr[i] = new int[i + 2];

			st = new StringTokenizer(br.readLine());

			for (int j = 1; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] DP = new int[N + 1][N + 1];

		DP[1][1] = arr[1][1];

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				DP[i][j] = Math.max(DP[i - 1][j - 1], DP[i - 1][j]);
				DP[i][j] += arr[i][j];
			}

		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = max < DP[N][i] ? DP[N][i] : max;
		}

		System.out.println(max);

	}

}
