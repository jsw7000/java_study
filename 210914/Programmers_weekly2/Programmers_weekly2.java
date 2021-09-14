public class Solution {

	public String solution(int[][] scores) {
		double[] avg = getAvg(scores);
		String answer = getGrade(avg);
		return answer;
	}

	public static double[] getAvg(int[][] scores) {
		int N = scores.length;
		double[] avg = new double[N];
		for (int i = 0; i < N; i++) {
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;
			double sum = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				min = Math.min(min, scores[j][i]);
				max = Math.max(max, scores[j][i]);
				sum = sum + scores[j][i];

			}
			if (min > scores[i][i] || max < scores[i][i]) {
				avg[i] = sum / (N - 1);
			} else {
				sum += scores[i][i];
				avg[i] = sum / N;
			}

		}

		return avg;
	}

	public static String getGrade(double[] avg) {
		int N = avg.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			double num = avg[i];
			System.out.println(num);
			if (num >= 90)
				sb.append("A");
			else if (num >= 80)
				sb.append("B");
			else if (num >= 70)
				sb.append("C");
			else if (num >= 50)
				sb.append("D");
			else
				sb.append("F");

		}
		return sb.toString();
	}
}
