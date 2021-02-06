package HW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SecretEmail {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int N=str.length();
		
		Queue<Character> queue = new LinkedList<Character>();
		
		for(int i=0;i<str.length();i++) {
			queue.offer(str.charAt(i));
		}
		
		int R=0;
		int C=0;
		for(int i=1;i<=N;i++) {
			if(N%i==0) {//i의 배수
				if(i>N/i)
					break;
				if(R<i) {
					R=i;
					C=N/i;
				}
			}
		}
		
		
		char[][] secret = new char[R][C]; 
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				secret[j][i] = queue.poll();
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(secret[i][j]);
			}
		}
		System.out.print(sb);
		
	}

}
