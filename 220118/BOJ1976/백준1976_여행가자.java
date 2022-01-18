import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1976_여행가자 {

	static int N,M;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //200이하
		M = Integer.parseInt(br.readLine()); //1000이하
		
		StringTokenizer st;
		parents = new int[N+1]; //연결여부(부모) 저장
		
		make();
		
		for(int i=1;i<=N;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=1;j<=N;j++) {
				
				int tmp= Integer.parseInt(st.nextToken());
				
				if(tmp==1)
					union(i,j);
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		boolean chk = true;
		int start = find(Integer.parseInt(st.nextToken()));
		//시작 지점의 부모와 다음 순번의 계획의 부모가 같다면 연결되어있으므로 여행 가능!
		for(int i=1;i<M;i++) {
			int now = Integer.parseInt(st.nextToken());
			if(start != find(now)) {
				chk = false;
				break;
			}
			
		}
		
		if(chk) System.out.println("YES");
		else System.out.println("NO");
		
	}
	
	public static void make(){
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
	}
	public static void union(int a,int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot!=bRoot) parents[bRoot] = aRoot;

	}

	public static int find(int a) {
		if(a==parents[a]) return a;
		
		return parents[a] = find(parents[a]);
		//return find(parents[a]);
		
	}
}
