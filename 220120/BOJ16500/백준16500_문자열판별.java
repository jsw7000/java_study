import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 다시 풀 예정
public class 백준16500_문자열판별 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<String>();
		int[] DP = new int[S.length()+1];
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		
		for(int i=S.length()-1;i>=0;i--) {
			for(int j=i+1;j<S.length();j++) {
				if(DP[j]==1) {
					if(set.contains(S.substring(i, j))) DP[i]=1;
				}
			}
			if(set.contains(S.substring(i))) DP[i]=1;
		}
		System.out.println(DP[0]);
		
	}

}
