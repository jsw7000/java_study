package day210903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준10103_주사위게임 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int CY = 100;
		int SD = 100;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int cDice = Integer.parseInt(st.nextToken());
			int sDice = Integer.parseInt(st.nextToken());

			if (cDice == sDice)
				continue;
			else if (cDice < sDice)
				CY -= sDice;
			else
				SD -= cDice;

		}

		System.out.println(CY);
		System.out.println(SD);
	}
}
