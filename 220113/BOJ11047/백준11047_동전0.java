import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11047_동전0 {

	/*
	 * 최소 갯수의 동전으로 K원 만들기
	 * N K
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			coins[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int sum = 0 ;
		
		for(int i=N-1;i>=0;i--) {
			//만약 (K-sum)/coins[i]의 값이 0이라 continue;
			//div=(K-sum)/coins[i]의 값이 0 보다 크다면 ans+div 해주기 & sum+coins[i]*div
			
			int div = (K-sum)/coins[i];
			
			if(div>0) {
				ans = ans+div;
				sum = sum+(coins[i] * div);
			} else continue;
			
		}
		
		System.out.println(ans);
	}

}
