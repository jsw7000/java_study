package day210901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2138_Contact {
	/*
	 * 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구해라!
	 * 
	 * 인접배열 만들기
	 * 
	 * int[][] map;
	 * 
	 * BufferedReader로 문장 받음
	 * 
	 * for(int i=0;i<N/2;i++)
	 * 
	 * from,to
	 * 
	 * visited도 하기
	 * 
	 * 만약 visited
	 * 
	 * bfs로 탐색을 하는데 첫 시작점은 2라고 하면 visited[2]=true;
	 * 
	 * queue.offer(2) int max=-1; while(true){
	 * 
	 * int size = queue.size();
	 * 
	 * for(int s=0;s<size;s++){ int current = queue.poll; for(int
	 * i=0;i<map[current].size;i++){ if(!map[current][i]&&!visited[i]){
	 * queue.offer(i); max = max<i?i:max; visited[i]=true; }} } }
	 * 
	 * 
	 */
	static boolean[][] map;
	static int N, start;
	static int ans;

	public static void main(String[] args) throws IOException {

//		int T = Integer.parseInt(st.nextToken());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			map = new boolean[101][101];
			ans = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				map[from][to] = true;
			}

			bfs();

			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];

		queue.offer(start);
		visited[start] = true;
		int max = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			max = -1;

			for (int s = 0; s < size; s++) {

				int current = queue.poll();
				/*
				 * for(int i=0;i<map[current].size;i++){ if(!map[current][i]&&!visited[i]){
				 * queue.offer(i); max = max<i?i:max; visited[i]=true;
				 */
				max = max < current ? current : max;

				for (int i = 1; i < map[current].length; i++) {
//					System.out.println(current);
					if (map[current][i] && !visited[i]) {
						queue.offer(i);
						visited[i] = true;
					}
				}

			}
			ans=max;
		}
	}
}
