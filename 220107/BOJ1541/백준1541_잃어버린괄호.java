import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] sp = input.split("\\-"); //\을 구분자로 하여 문자열 파싱

		
		int ans = 0;
		int cnt = 0;
		while(cnt<sp.length) {
			
			String[] num = sp[cnt].split("\\+");
			int sum = 0;
			for(String n : num) {
				int tmp = Integer.parseInt(n);
				sum+=tmp;
			}
			if(cnt==0)
				ans+=sum;
			else 
				ans-=sum;
			cnt++;
			
		}
		System.out.println(ans);
		
		
	}

}
