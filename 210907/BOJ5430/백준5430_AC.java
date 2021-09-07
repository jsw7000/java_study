package day210907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 백준5430_AC {
	/*
	 * R : 배열에 있는 숫자의 순서 뒤집기, D : 첫번째 숫자 버리기 배열이 비어있는데 D를 사용하는 경우에는 에러발생
	 * 
	 * RDD : 배열을 뒤집은 다음 처음 두 숫자를 버리는 함수
	 * 
	 * 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {

//			st = new StringTokenizer(br.readLine());

			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());

			String strArr = br.readLine();
			strArr = strArr.substring(1, strArr.length() - 1);
			String[] arr = strArr.split(",");

			Deque<Integer> deque = new ArrayDeque<Integer>();
			for (String s : arr) {
				if (!s.equals(""))
					deque.addLast(Integer.parseInt(s));
			}

			func(p, sb, deque);

		}

		System.out.print(sb.toString());

	}

	public static void func(String p, StringBuilder sb, Deque<Integer> deque) {

		boolean isRight = false; // 방향 상태 변수

		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);

			if (ch == 'R') {
				isRight = !isRight;
				continue;
			} else {
				if (deque.size() == 0) {
					sb.append("error\n");
					return;
				}

				if (isRight) { // 오른쪽 방향 경우
					deque.removeLast();
				} else if (!isRight) { // 왼쪽 방향인 경우
					deque.removeFirst();
				}
			}
		}
		printDeque(sb, deque, isRight);
	}

	public static void printDeque(StringBuilder sb, Deque<Integer> deque, boolean isRight) {

		sb.append("[");
		while (!deque.isEmpty()) {
			sb.append(isRight ? deque.removeLast() : deque.removeFirst());
			if (deque.size() != 0)
				sb.append(",");
		}

		sb.append("]\n");
	}
}
