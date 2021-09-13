import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준2580_스도쿠 {
	/*
	 * 각각의 세로줄 & 가로줄에는 1~9까지의 숫자가 한 번씩만 나타나야 함 3X3 정사각형 안에도 1~9번호 한번씩만
	 * 
	 * isAvailable로 해야할듯{ 세로검사 가로검사 사각형검사}
	 */
	static int N, max;
	static int[][] map;
	static ArrayList<Point> list;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		N = 9;
		map = new int[N][N];
		list = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new Point(i, j));
				}
			}
		}
//		boolean[] check = new boolean[N];
		go(0);
		
		
	}

	public static void go(int idx) {
		
		if(idx==list.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			System.exit(0);
		}
		Point point = list.get(idx);

		int[] ver = new int[N];
		for (int i = 0; i < N; i++) {
			ver[i] = map[point.y][i];
		}
		for(int i=1;i<=9;i++) {
			if(horizontal(map[point.x],i)&&vertical(ver,i)&&rect(map, point.x, point.y,i)) {
				map[point.x][point.y] = i;
				print(map);
				go(idx+1);
			}
			
			if(i==9) map[point.x][point.y]=0;
		}

		// 먼저 가로,세로,사각형 탐색 돌리고 존재하지 않는 숫자들을 받아온다.



		// 존재하지 않는 숫자들 중에서 아무거나 넣고 go보내기?

		// go를 보냈는데 맞는게 아니라면? return
		// 다른 숫자로 채워보는거지

	}
//	public static boolean isAvailable() {
//		
//	}
	public static void print(int[][] map) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println("\n");
		}
		System.out.println("==========================");
	}
	public static int[][] copy(int[][] map) {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}

	public static boolean horizontal( int[] arr,int check) {

		for (int i = 0; i < N; i++) {
			if (arr[i] == check)
				return false;
		}
		return true;
	}

	public static boolean vertical(int[] arr,int check) {
		for (int i = 0; i < N; i++) {
			if (arr[i] == check)
				return false;
		}
		return true;
	}

	public static boolean rect(int[][] arr, int x, int y,int check) {
		boolean tf= true;
		if (x < 3) {
			if (y < 3) {
				tf = rect_go(arr, 0, 3, 0, 3,check);
			} else if (y >= 3 && y < 6) {
				tf = rect_go(arr, 3, 6, 3, 6,check);
			} else if (y >= 6) {
				tf = rect_go(arr, 6, 9, 6, 9,check);
			}
		} else if (x >= 3 && x < 6) {
			if (y < 3) {
				tf = rect_go(arr, 0, 3, 0, 3,check);
			} else if (y >= 3 && y < 6) {
				tf = rect_go(arr, 3, 6, 3, 6,check);
			} else if (y >= 6) {
				tf = rect_go(arr, 6, 9, 6, 9,check);
			}
		} else if (x >= 6) {
			if (y < 3) {
				tf = rect_go(arr, 0, 3, 0, 3,check);
			} else if (y >= 3 && y < 6) {
				tf = rect_go(arr, 3, 6, 3, 6,check);
			} else if (y >= 6) {
				tf = rect_go(arr, 6, 9, 6, 9,check);
			}
		}
		return tf;
	}

	public static boolean rect_go(int[][] arr, int starti, int endi, int startj, int endj,int check) {
		for (int i = starti; i < endi; i++) {
			for (int j = startj; j < endj; j++) {
				if (arr[i][j] == check)
					return false;
			}
		}
		return true;
	}
}
