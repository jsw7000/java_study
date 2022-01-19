import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1043_거짓말 {

	static int[] people;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		people = new int[N+1];//사람의 
		int[] party = new int[M];
		
		make(N);
		
		st = new StringTokenizer(br.readLine());
		int truth = Integer.parseInt(st.nextToken());
		for(int i=0;i<truth;i++) {
			people[Integer.parseInt(st.nextToken())] = -1; //진실을 아는 사람
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			
			int first=51,second=51;
			
			for(int j=0;j<size;j++) {
				
				
				first=second;
				second = Integer.parseInt(st.nextToken());
				
				if(first>50) {
					continue;
				}
				
				union(first,second);
				
			}
			party[i] = second;
		}
		
		int cnt =0;
		for(int i=0;i<M;i++) {
			int find = find(party[i]);
			if(find!=-1) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static void make(int N) {
		//초기화
		for(int i=1;i<=N;i++) {
			people[i]=i;
		}
	}
	public static int find(int a) {
		if(a==-1) return -1;
		if(a==people[a]) return a;
		return people[a]=find(people[a]);
	}
	
	public static void union(int a,int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot!=bRoot) {
			if(aRoot<bRoot)
				people[bRoot]=aRoot;
			else if(aRoot>bRoot) people[aRoot]=bRoot;
		}
	}

}
