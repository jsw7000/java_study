import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA4013_특이한자석 {
	static class Magnet{
		int idx;
		int dir;
		
		public Magnet(int idx, int dir) {
			super();
			this.idx = idx;
			this.dir = dir;
		}
	}
	static int[] di= {-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for(int tc=1; tc<=TC;tc++) {
			int K = Integer.parseInt(br.readLine()); //회전시키는 횟수
			int[][] arr = new int[4][8];//4개의 자석,8면
			
			StringTokenizer st = null;
			
			for(int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Magnet> queue = new LinkedList<>();
			
			for(int k=0;k<K;k++) { // K번 회전
				
				st = new StringTokenizer(br.readLine());
				
				boolean[] used = new boolean[4];
				
				int idx = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken()); //1:시계방향, -1 : 반시계 방향
				
				//내 좌우 자성 확인 left,right
				//queue에 add
				queue.add(new Magnet(idx,dir));
				
				while(!queue.isEmpty()){
				
				Magnet magnet = queue.poll();
				
				if(used[magnet.idx]) continue;
				used[magnet.idx] = true;
				//좌우 방향 확인
					for(int d=0;d<di.length;d++) {
						
						int ni = magnet.idx+di[d];
						
						//범위를 벗어난다면 continue;
						if(ni<0||ni>=4||used[ni]) continue;
						
						
						//범위를 벗어나지 않는다면 자성 확인
						if(d==0) {
							// 현재 자성과 반대라면 queue.add
							if(arr[magnet.idx][6]!=arr[ni][2]) {
								queue.add(new Magnet(ni,-magnet.dir));
							}
						}else if(d==1) {
							if(arr[magnet.idx][2]!=arr[ni][6]) {
								queue.add(new Magnet(ni,-magnet.dir));
							}
						}
						
					}
					//현재 idx, spinArr();
					spinArr(arr[magnet.idx],magnet.idx,magnet.dir);
					
				
				}
			}
			sb.append("#"+tc+" "+countResult(arr)+"\n");
			
		}
		
		System.out.println(sb.toString());
		
		
	}
	//배열 돌리기
	public static void spinArr(int[] arr,int idx,int dir) { //배열,돌리는 방향, 돌리는 자석의 idx
		
		if(dir==-1) {
			int start = arr[0];
			for(int i=0;i<7;i++) {
				arr[i]=arr[i+1];
			}
			arr[7] = start;
		}else if(dir==1) {
			int end = arr[7];
			for(int i=7;i>0;i--) {
				arr[i]=arr[i-1];
			}
			arr[0] = end;
		}
		
	}
	//최종 계산
	public static int countResult(int[][] arr) {
		int sum = 0;
		for(int i=0;i<4;i++) {
			if(arr[i][0]==1) {
				sum+=Math.pow(2,i);
			}
		}
		return sum;
	}

}
