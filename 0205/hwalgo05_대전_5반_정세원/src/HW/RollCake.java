package HW;

import java.util.Scanner;
public class RollCake {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int N = sc.nextInt();
		int[][] person = new int[N + 1][2]; // 방청객의 번호를 적을 배열

		for (int i = 1; i < person.length; i++) {
			for (int j = 0; j < 2; j++) {
				person[i][j] = sc.nextInt();
			}
		}
		int max = -1;
		int max_idx = 0;
		for (int i = 1; i < person.length; i++) {
			int range = (person[i][1] - person[i][0]);
			if (max < range) {
				max = range;
				max_idx = i;
			}
		}
		System.out.println(max_idx);
		
		int[] count = new int[N+1];
		int[] rollcake = new int[L+1];
		for (int i = 1; i < person.length; i++) {
			for (int j = person[i][0]; j <= person[i][1]; j++) {
				if(rollcake[j]==0) {
					rollcake[j]=i;
					count[i]++;
				}else continue;
			}
		}
		
		int real=1;
		for(int i=2;i<count.length;i++) {
			if (count[real] < count[i]) {
				real = i;
			}
		}
		System.out.println(real);

	}

}
