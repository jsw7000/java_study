package day210901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1759_암호만들기 {

	/*
	 * 서로 다른 L개의 알파벳 소문자들로 구성
	 * 최소 한 개의 모음(a,e,i,o,u)과 최소 두 개의 자음으로 구성
	 * 
	 * 알파벳이 암호에서 증가하는 순서로 배열되었을 것
	 * 
	 * 
	 * 콤비네이션 사용
	 * 
	 * 
	 * */
	static int L,C;
	static char[] alpha;
	static char[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		result = new char[L];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		
		dfs(0,0);
		
	}
	
	public static void dfs(int index,int cnt) {
		
		if(cnt==L) {
			StringBuilder sb = new StringBuilder();
			int m = 0;
			int j = 0;
			for(int i=0;i<L;i++) {
				char ch = result[i];
				if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') m++;
				else j++;
				sb.append(ch);
			}
			
			if(m>=1&&j>=2) System.out.println(sb);
			return;
		}
		if(index==C) return;
		
		result[cnt]=alpha[index];
			dfs(index+1,cnt+1);
			dfs(index+1,cnt);
		
	}

}
