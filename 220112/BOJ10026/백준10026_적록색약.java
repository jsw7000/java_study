import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준10026_적록색약 {

	/*
	 * NxN, RGB 중 하나를 색칠한 그림
	 * 구역은 같은 색으로 이뤄져있음같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
	 * 색상의 차이를 거의 느끼지 못하는 경우도 같은 색상
	 * 
	 * 
	 * */
	static int N;
	
	static int[] di = {-1,1,0,0};//상,하,좌,
	static int[] dj = {0,0,-1,1};
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] normalMap = new char[N][N]; //적록색약이 아닌 경우의 배열
		char[][] specialMap = new char[N][N];//적록색약인 경우의 배열
		
		int normalCnt=0,specialCnt=0; //구역의 개수 카운트 변수 

		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				char ch = str.charAt(j);
				normalMap[i][j]=ch;
				if(ch=='G') { //적록색약인 경우, R과 G를 동일한 색으로 인식하므로 동일 색으로 배열에 대입
					specialMap[i][j]='R';
				}else specialMap[i][j] = ch;
				
			}
		}
		
		
		//일반의 경우
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(normalMap[i][j]!='V') { //방문하지 않은 경우에만 bfs탐색
					seeing(normalMap,i,j);
					normalCnt++;
				}
				if(specialMap[i][j]!='V') {
					seeing(specialMap,i,j);
					specialCnt++;
				}
			}
		}
		
		System.out.println(normalCnt+" "+specialCnt);
		
		
		
	}
	public static void seeing(char[][] map,int x,int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x,y));
		char color = map[x][y]; // 구역 색깔
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			//방문했다면 continue;
			if(map[current.x][current.y]=='V') continue;
			
			//방문 여부 체크
			map[current.x][current.y]='V';
			
			//방문 하지 않았다면 for문 돌기
			for(int d=0;d<4;d++) {
				//범위를 벗어나지 않으면서 동일한 color라면 push
				int ni = current.x+di[d];
				int nj = current.y+dj[d];
				
				if(ni<N&&ni>=0&&nj<N&&nj>=0&&map[ni][nj]==color) {
					queue.add(new Point(ni,nj));
				}
			}
			
		}
		
	}

}
