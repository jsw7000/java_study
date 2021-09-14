package day210913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1697_숨바꼭질 {
	
	static int ans;
	static class Point {
		int idx;
		int time;

		public Point(int idx, int time) {
			super();
			this.idx = idx;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(ans);
	}

	public static void bfs(int N, int K) {
		Queue<Point> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001];

		queue.add(new Point(N, 0));// 시작 지점 queue에 add
		while (!queue.isEmpty()) {

			// queue.poll()
			Point current = queue.poll();

			// 방문했어? 그럼 그냥 넘긴다.
			if (visited[current.idx])
				continue;

			// 현재 위치==동생? 그럼 return!
			if (current.idx == K) {
				ans = current.time;
				return;
			}

			// 방문 안했으면 방문처리하고
			visited[current.idx] = true;

			// 범위체크하고 내 양옆/순간이동 위치 queue에 넣기!
			if (current.idx - 1 >= 0) {
				queue.add(new Point(current.idx - 1, current.time + 1));
			}

			if (current.idx + 1 < 100001) {
				queue.add(new Point(current.idx + 1, current.time + 1));
			}
			if (current.idx * 2 < 100001 && current.idx * 2 >= 0) {
				queue.add(new Point(current.idx * 2, current.time + 1));

			}
		}

	}

}
