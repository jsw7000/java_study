import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준12904_A와B {

	
	static String T;
	static int palinCheck=0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		T = br.readLine();
		int size = T.length();

		for(int i=size;i>0;i--) {
			char t = T.charAt(T.length()-1);
			T = T.substring(0,T.length()-1);
			
			//끝이 B라 뒤집어 준다
			if(t=='B') {
				StringBuilder sb = new StringBuilder(T);
				T = sb.reverse().toString();
			}			
			
			//S와 길이가 동일하면 비교
			if(T.length()==S.length()) {
				if(T.equals(S)) {
					palinCheck=1;
					break;
				}
			}
			
		}
		

		System.out.println(palinCheck);
		

	}
//	
//	public static void dfs(String str) {
//		
//		if(str.length()==T.length()) {
////			System.out.println(str);
//			if(str.equals(T)) {
//				palinCheck=1;
//			}
//			
//			return;
//		}
//		
//		//문자열 뒤에 A를 추가하는 경우
//		dfs(str+"A");
//		
//		//문자열을 뒤집고 뒤에 B를 추가하는 경우
//		String tmp="";
//		for(int i=str.length()-1;i>=0;i--) {
//			tmp+=str.charAt(i);
//		}
//		dfs(tmp+"B");
//	}
//	
//	public static int bfs(String S) {
//		Queue<String> queue = new LinkedList<String>();
//		queue.add(S);
//		int check = 0;
//		
//		while(!queue.isEmpty()) {
//			
//			int size = queue.size();
//			
//			for(int s=0;s<size;s++) {
//				String str = queue.poll();
////				System.out.println(str);
//				if(str.length()==T.length()) {
//					if(str.equals(T)) {
//						palinCheck=1;
//						break;
//					}
//				}
//				if(str.length()<T.length()) {
//					queue.add(str+"A");
//					String tmp="";
//					for(int i=str.length()-1;i>=0;i--) {
//						tmp+=str.charAt(i);
//					}
//					queue.add(tmp+"B");
//				}
//			}
//			
//		}
//		
//		return palinCheck;
//	}

}
