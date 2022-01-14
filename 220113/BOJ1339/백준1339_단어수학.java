import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준1339_단어수학 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		String[] words = new String[N];
		for(int i=0;i<N;i++) {
			words[i] = br.readLine();
			int temp = (int)Math.pow(10, words[i].length()-1);
			for(int s=0,size=words[i].length();s<size;s++) {
				int word = words[i].charAt(s) - 65;
				alpha[word]+=temp;
				temp/=10;
			}
		}
		Arrays.sort(alpha);

		int num = 9;
		int sum = 0;
		for(int i=alpha.length-1;i>=0;i--) {
			if(alpha[i]==0) break;
			
			sum+=alpha[i]*num;
			num--;
			
		}
		
		System.out.println(sum);
		
	}

}
