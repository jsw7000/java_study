import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준10163_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int M = 1001;
		int[][] map = new int[M][M];
		int[] result = new int[N+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			//가장 왼쪽아래 칸의 번호
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			//너비
			int width = Integer.parseInt(st.nextToken());
			//높이
			int height = Integer.parseInt(st.nextToken());
			
			for(int r=x;r<x+height;r++) {
				for(int c=y;c<y+width;c++) {
					map[r][c] = i+1;
				}
			}
		}
		
		
		for(int i=0;i<1001;i++) {
			for(int j=0;j<1001;j++) {
				result[map[i][j]]++;
			}
		}
		
		for(int i=1;i<result.length;i++)
			sb.append(result[i]+"\n");
		
		System.out.println(sb.toString());
		
	}

}
