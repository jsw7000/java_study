package HW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IM대비_의석이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			sb.setLength(0);
			int max = 0;
			ArrayList<Queue> list = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				Queue<Character> queue = new LinkedList<>();
				String str = sc.nextLine();
				max = max < str.length() ? str.length() : max;
				for (int j = 0; j < str.length(); j++) {
					queue.offer(str.charAt(j));
				}
				list.add(queue);
			}

			int cnt = 0;
			while (cnt != max) {
				for (int i = 0; i < 5; i++) {
					if(list.get(i).peek()==null) continue;
					sb.append(list.get(i).poll());
				}
				cnt++;
			}
			System.out.println("#"+tc+" "+sb);

		}
	}

}
