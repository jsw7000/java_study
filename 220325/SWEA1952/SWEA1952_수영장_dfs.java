import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1952_수영장_dfs {
	
	static int n=4,m=12;
	static int ans;
	static int[] voucher;
	static int[] month;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=TC;tc++) {
			
		
			voucher = new int[n]; //이용권 가격
			month = new int[m];
			ans = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				voucher[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) {
				month[i] = Integer.parseInt(st.nextToken()); //월 별 이용 횟수
				
				}
			dfs(0,0);
			
			sb.append("#"+tc+" "+Math.min(voucher[3], ans)+"\n");
		}
		
	System.out.println(sb.toString());
	
}
	public static void dfs(int idx,int cost) {
		if(idx>=m) {
			//최소 비교
			ans = ans>cost?cost:ans;
			return;
		}
		
		if(month[idx]==0) dfs(idx+1,cost);
		
		dfs(idx+1,cost+month[idx]*voucher[0]);
		dfs(idx+1,cost+voucher[1]);
		dfs(idx+3,cost+voucher[2]);
		
	}

}
