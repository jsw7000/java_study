package HW;

import java.util.Scanner;

public class SuperMario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] mushroom = new int[10];

		for (int i = 0; i < mushroom.length; i++) {
			mushroom[i] = sc.nextInt();
		}

		int dif = 100;
		int sum = 0;
		for (int i = 0; i < mushroom.length; i++) {
			sum += mushroom[i];
			if (dif < Math.abs(100 - sum)) {
				sum -= mushroom[i];
				break;
			} else if (dif == Math.abs(100 - sum)) {
				if (sum >= 100)
					break;
			} else
				dif = Math.abs(100 - sum);
		}

		System.out.println(sum);
	}

}
