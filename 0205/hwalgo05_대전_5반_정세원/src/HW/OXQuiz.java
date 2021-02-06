package HW;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OXQuiz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC=sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int cnt=0;
			String str = sc.next();
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='O') { //O
					cnt++;
					queue.offer(cnt);
				}else { //X
					cnt=0;
					queue.offer(0);
				}
			}
			int sum=0;
			while(!queue.isEmpty()) 
			{
				sum+=queue.poll();
			}
			System.out.println(sum);
		}
	}

}