import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준1935_후위표기식2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String str = br.readLine();
		double[] num = new double[N];
		for (int i = 0; i < N; i++) {
			num[i] = Double.parseDouble(br.readLine());
		}

		Stack<Double> stack = new Stack<>();
		for (int s = 0; s < str.length(); s++) {
			char ch = str.charAt(s);
			if ('A' <= ch && ch <= 'Z') {
				int idx = (int) ch - 65;
				stack.push(num[idx]);
			} else {
				// 숫자 두 개 꺼내기!
				double second = stack.pop();
				double first = stack.pop();
				double cal = 0;
				// *인지,+인지,/인지,-인지
				if (ch == '*') {
					cal = first * second;
				} else if (ch == '+') {
					cal = first + second;
				} else if (ch == '/') {
					cal = first / second;
				} else if (ch == '-') {
					cal = first - second;
				}

				// cal값 push
				stack.push(cal);
			}
		}

		double ans = stack.pop();
		System.out.printf("%.2f", ans);
	}

}
