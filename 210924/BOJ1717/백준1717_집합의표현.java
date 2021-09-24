import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1717_집합의표현 {

	static int[] parent; // 부모
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];

		make();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (type == 0) { // union
				union(a, b);
			} else if (type == 1) { // find
				int findA = find(a);
				int findB = find(b);
				if (findA == findB)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}

		}

		System.out.println(sb.toString());
	}

	// 합
	static public void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);

		if (parentA != parentB) {
			if (parentA > parentB)
				parent[parentA] = parentB;
			else if (parentA < parentB)
				parent[parentB] = parentA;
		}
	}

	// 초기화 함수
	static public void make() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	// 부모 비교
	static public int find(int num) {
		if (parent[num] == num)
			return num;
		else
			return parent[num] = find(parent[num]);
	}
}
