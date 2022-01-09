import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준5525_IOIOI {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int cnt = 0;
		int checkCnt = 0;
		
		for(int i=0;i<M-2;i++) {
			if(S.charAt(i)=='I'&&S.charAt(i+1)=='O'&&S.charAt(i+2)=='I') {
				checkCnt++;
				if(checkCnt==N) {
					checkCnt--;
					cnt++;
				}
				i++;
			}else {
				checkCnt=0;
			}

		}
		
		System.out.println(cnt);

	}

}
