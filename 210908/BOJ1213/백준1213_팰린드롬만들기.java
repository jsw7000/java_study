package day210908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준1213_팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eng = br.readLine();
		
		char[] arr = eng.toCharArray();
		int len = arr.length;
		
		int[] alpha = new int[26]; //A-Z 갯수! 'A-'0'
		for(int i=0;i<arr.length;i++) {
			int intAlpah = (int)arr[i]-65; // A : 0, B : 2 ,....
			alpha[intAlpah]++;
		}

		int odd = 0; // 짝수 홀수 체크
		for(int i=0;i<alpha.length;i++) {
			if(alpha[i]%2!=0) odd++;
		}
		
		if(odd>1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		char[] ans = new char[len];
		int idx =0;
		if(odd==1) {
			for(int i=0;i<alpha.length;i++) {
				int cnt = alpha[i];
				if(cnt%2!=0) {
					ans[len/2] = (char)(i+65);
				}
				for(int c = 0;c<cnt/2;c++) {
					ans[idx] = ans[len-idx-1] = (char)(i+65);
					idx++;
				}
			}
		}else if(odd==0) {
			for(int i=0;i<alpha.length;i++) {
				int cnt = alpha[i];
				for(int c = 0;c<cnt/2;c++) {
					ans[idx] = ans[len-idx-1] = (char)(i+65);
					idx++;
				}
			}
			
		}

		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]);
		}
	}

}
