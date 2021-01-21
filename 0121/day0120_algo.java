package prepare.algo;

import java.util.Scanner;

public class day0120_algo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i =1;
		while(i<=n) {
			int count =0;
			String figure = String.valueOf(i);
			char[] Array = new char[figure.length()];
			Array = figure.toCharArray();
			
			for(int j=0;j<Array.length;j++) {
				if(Array[j]%3==0&&Array[j]!=0) {
					count++;
				}
			}
			
			if(count==0) {
				System.out.print(figure+" ");
			}
			else{
				for(int j=0;j<count;j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
			i++;
		}
		sc.close();
	}

}
