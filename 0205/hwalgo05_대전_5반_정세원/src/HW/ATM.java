package HW;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//사람 수
		//사람들이 줄을 서는 순서에 따라, 돈을 인출하는데 필요한 시간의 합이 달라짐
		int[] person = new int[N];
		for(int i=0;i<person.length;i++) {
			person[i]= sc.nextInt();
		}
		int sum=0;
		Arrays.sort(person);
		for(int i=0;i<person.length;i++) {
			for(int j=0;j<=i;j++) {
				sum+=person[j];
			}
		}
		System.out.println(sum);
	}

}
