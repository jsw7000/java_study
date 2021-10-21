import java.util.*;

class Main {
    static int N; //배열의 크기
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {-1,1,0,0}; //상,하,좌,우
    static int[] dj = {0,0,-1,1};
    static ArrayList<Point> list = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
  private static void solution(int sizeOfMatrix, int[][] matrix) {
		N = sizeOfMatrix;
		map = new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				map[i][j]=matrix[i][j];
				if(map[i][j]==1){
					list.add(new Point(i,j));
				}
			}
		}
		visited = new boolean[N][N];
		
		for(int l=0;l<list.size();l++){
			Point point = list.get(l);
			if(visited[point.x][point.y]) continue;
			bfs(point.x,point.y);
		}
		
		Collections.sort(result);

		StringBuilder sb = new StringBuilder();
		sb.append(result.size()+"\n");
		for(int r = 0; r<result.size();r++){
			sb.append(result.get(r)+" ");	
		}
		
		System.out.print(sb.toString());
		
  }
	
	public static void bfs(int nowi,int nowj){
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(nowi,nowj));
		int cnt = 0;
		while(!queue.isEmpty()){
			Point current = queue.poll();
			
			if(visited[current.x][current.y]) continue;
			
			visited[current.x][current.y] = true;
			cnt++;
			
			for(int d=0;d<4;d++){
				int ni = current.x + di[d];
				int nj = current.y + dj[d];
				
				if(ni<0||nj<0||ni>=N||nj>=N||map[ni][nj]!=1||visited[ni][nj]) continue;
				
				queue.add(new Point(ni,nj));
				
			}
			
			
		}
		
		result.add(cnt);
		
	}
  private static class InputData {
    int sizeOfMatrix;
    int[][] matrix;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      
      inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
      for (int i = 0; i < inputData.sizeOfMatrix; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.sizeOfMatrix; j++) {
          inputData.matrix[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.sizeOfMatrix, inputData.matrix);
  }
}