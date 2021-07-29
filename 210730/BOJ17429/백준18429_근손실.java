package day210730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준18429_근손실 {

	static int N, K;
	static int[] kit;
	static int[] result;
	static int ans;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		kit = new int[N];
		used = new boolean[N];
		result = new int[N];

		for (int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}

		getWeight(0, 500);
		System.out.println(ans);
	}

	public static void getWeight(int cnt, int weight) {
		if (weight < 500)
			return;
		if (cnt == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				used[i] = true;
				getWeight(cnt + 1, weight - K + kit[i]);
				used[i] = false;
			}

		}
	}
}
