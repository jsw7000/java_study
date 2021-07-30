

import java.util.Arrays;

public class TargetNumber {
	static int[] arr;
	static boolean[] used;
	static int count, T;

	public int solution(int[] numbers, int target) {

		// arr = new int[numbers.length];
		arr = numbers;
		System.out.println(Arrays.toString(arr));
		used = new boolean[arr.length];
		T = target;

		// 음수로 (*-1)해서 넣는 경우, 그냥 (*1)로 해서 넣는 경우

		getCalculate(0, 0);
		int answer = count;

		return answer;
	}

	public static void getCalculate(int idx, int cal) {

		if (idx == arr.length) {
			if (cal == T)
				count++;
			return;
		}

		getCalculate(idx + 1, cal + ((-1) * arr[idx]));
		getCalculate(idx + 1, cal + arr[idx]);
	}
}
