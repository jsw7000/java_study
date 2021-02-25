import java.util.Scanner;

public class 백준10163_색종이 {
	public static void main(String[] args) {
		// N장의 색종이가 주어진 위치에 차례로 놓일 경우, 각 색종이가 보이는 부분의 면적을 구하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = 0;
			}
		}

		for (int n = 1; n <= N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int xp = sc.nextInt();
			int yp = sc.nextInt();
			for (int i = x; i < x + xp; i++) {
				for (int j = y; j < y + yp; j++) {
					map[i][j] = n;
				}
			}
		}
		for (int n = 1; n <= N; n++) {
			int cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j]==n)
						cnt++;
				}
			}
			System.out.println(cnt);
		}

	}

}
