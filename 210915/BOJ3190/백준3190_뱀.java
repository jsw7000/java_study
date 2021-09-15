import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준3190_뱀 {
	static int[][] map; // 1: 사과가 위치, 2: 뱀의 몸
	static int N, K, L; // 보드의 크기, 사과의 개수
	static char[] change = new char[10001]; // 방향 전환을 담을 배열

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int[] di = { 0, 1, 0, -1 }; // 우,하,좌,상
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}

		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			change[time] = dir;
		}

		int ans = dummy();
		System.out.println(ans);

	}

	public static int dummy() {
		Deque<Point> deque = new ArrayDeque<>(); // 뱀의 몸의 좌표 저장
		deque.add(new Point(1, 1));
		map[1][1] = 2;
		int time = 0;
		int dir = 0;

		Point head = deque.getFirst();
		while (true) {

			time++;

			int nexti = head.x + di[dir];
			int nextj = head.y + dj[dir];

			if (nexti < 1 || nextj < 1 || nexti > N || nextj > N)
				return time;

			deque.addFirst(new Point(nexti, nextj));

			head = deque.getFirst();

			if (time != 0) {

				if (map[head.x][head.y] == 1) {	//사과가 있는 경우
					map[head.x][head.y] = 2;
				} else if (map[head.x][head.y] == 0) {	// 사과가 없는 경우
					Point point = deque.pollLast();
					map[point.x][point.y] = 0;
					map[head.x][head.y] = 2;
				} else if (map[head.x][head.y] == 2) {	// 내 몸이네? 그럼 게임 종료
					return time;
				}
			}

			// 방향을 바꿀 시간인지
			char ch = change[time];
			if (ch == 'L') {
				dir = ((dir + 3) % 4);
			} else if (ch == 'D') {
				dir = (dir + 1) % 4;
			}

		}

	}
}
