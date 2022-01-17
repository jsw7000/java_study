import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준1715_카드정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			long num = Integer.parseInt(br.readLine());
			pq.add(num);
			
		}

		long sum = 0;
		while(true) {
			long n1 = pq.poll();
			long n2 = pq.poll();
			
			
			sum += (n1+n2);
			
			if(pq.isEmpty()) {
				break;
			}
			pq.add((n1+n2));
		}

		System.out.println(sum);
	}

}

