import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1 : 집이 있는 곳 0 : 집이 없는 곳
 * 
 * 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 
 * di,dj 사방향 필요 visited 방문 여부 관리 필요
 * 
 * 몇번째 단지인지 count 필요 단지 내 집의 수도 count해야함 이거는 그냥 마지막에 for문으로 세서 배열에 넣고 sort하면 될듯?
 * 
 * 나는 bfs로 할그
 */
public class 백준2667_단지번호붙이기 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static ArrayList<Point> list = new ArrayList<Point>();
	static int count=0; //단지 수 카운트
	static ArrayList<Integer> numOfHouse = new ArrayList<Integer>();
	
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.valueOf(str.substring(j,j+1));
				if(map[i][j]==1) {
					list.add(new Point(i,j));
				}
			}
		}
		
		for(int i=0;i<list.size();i++) {
			Point point = list.get(i);
			
			if(map[point.x][point.y]==1&&!visited[point.x][point.y]) {
				bfs(point);
			}
		}
		
		Collections.sort(numOfHouse);
		
		System.out.println(count);
		for(int i=0;i<count;i++)
			System.out.println(numOfHouse.get(i));
	}
	public static void print() {
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		System.out.println("----------------");
	}
	public static void bfs(Point point) {
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.offer(point);
		visited[point.x][point.y] = true;
		int num =1;
		count++;
		while(!queue.isEmpty()){
			
			Point current = queue.poll();
			
			for(int d=0;d<4;d++) {
				int ni = current.x + di[d];
				int nj = current.y + dj[d];
				
				if(ni<0||nj<0||ni>=N||nj>=N||map[ni][nj]==0||visited[ni][nj]) continue;
				
				map[ni][nj] = count;
				visited[ni][nj] = true;
				queue.offer(new Point(ni,nj));
				num++;
			}
			
		}
		numOfHouse.add(num);
	}

	
}