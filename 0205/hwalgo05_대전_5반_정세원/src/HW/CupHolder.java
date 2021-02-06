package HW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CupHolder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		char[] seat = new char[N];
		seat = str.toCharArray();
		
		Queue<Character> queue = new LinkedList<Character>();
		
		for(int i=0;i<seat.length;i++) {
			queue.offer(seat[i]);
		}
		int cnt=1;
		char ch;
		while(!queue.isEmpty()) {
			ch=queue.poll();
			if(ch=='S') {
				cnt++;
			}else if(ch=='L') {
				queue.poll();
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
