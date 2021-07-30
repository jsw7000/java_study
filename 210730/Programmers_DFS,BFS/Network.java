package day210730;

public class Network {
	static int[] arr;
	public static void main(String[] args) {
		
		int n =3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		boolean[] visited = new boolean[n];
		int answer=0;
		
		arr = new int[n];
		make(arr); //배열 초기화
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(computers[i][j]==1) {
					union(i,j);
				}
				
			}
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			answer++;
			for(int j=i;j<n;j++) {
				if(find(i)==find(j)) visited[j]=true;
			}
		}
	}
	
	public static void make(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
		}
	}
	
	public static void union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a!=b)
			arr[b]=a;
	}
	
	public static int find(int a) {
		if(arr[a]==a)
			return a;
		else
			return arr[a]=find(arr[a]);
	}
}
