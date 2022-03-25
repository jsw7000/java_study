import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1952_수영장 {
	
	/*
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int TC = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			StringBuilder sb = new StringBuilder();
			
			for(int tc=1;tc<=TC;tc++) {
				
				int n = 4;//이용권 갯수
				int m = 12; //1~12월
				int[] voucher = new int[n]; //이용권 가격
				int[] dp = new int[m+1]; //dp
//				int[][] dp = new int[][]
				st = new StringTokenizer(br.readLine());
				for(int i=0;i<n;i++) {
					voucher[i] = Integer.parseInt(st.nextToken());
				}
				
				st = new StringTokenizer(br.readLine());
				for(int i=1;i<=m;i++) {
					int days = Integer.parseInt(st.nextToken()); //월 별 이용 횟수
					dp[i]=Math.min(dp[i-1]+voucher[0]*days, dp[i-1]+voucher[1]);	
					
					if(i>=3) {
						dp[i]=Math.min(dp[i],dp[i-3]+voucher[2]);
					}
					
				}
				dp[m] = Math.min(dp[m], voucher[3]);
				
				sb.append("#"+tc+" "+dp[m]+"\n");
				
			}
			
		System.out.println(sb.toString());
		
	}
}
