package day220106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준6603_로또 {
	static int K,N;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = 6;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			K = Integer.parseInt(st.nextToken());
			
			if(K==0) break;
			
			arr = new int[K];
			result = new int[N];
			
			for(int i=0;i<K;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0,0);
			
			sb.append("\n");
			
		}
		
		System.out.print(sb.toString());
		
	}
	public static void permutation(int start, int cnt) {
		if(cnt==N) {
			int[] pArr = new int[N];
			pArr = copy(result);
			Arrays.sort(pArr);
			for(int i=0;i<N;i++)
				sb.append(pArr[i]+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<K;i++) {
			result[cnt] = arr[i];
			permutation(i+1, cnt+1);
		}
	}
	public static int[] copy(int[] result) {
		int[] pArr = new int[N];
		for(int i=0;i<N;i++) {
			pArr[i]= result[i];
		}
		return pArr;
	}

}
