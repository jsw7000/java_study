import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백준1931_회의실배정 {

	
	/*
	 * 한 개의 회의실 , N개의 회의에 대하여 회의실 사용표를 만들기
	 * 각 회의 I에 대해 시작시간과 끝나는시간이 주어짐
	 * 각 회의 겹치지 않으면서 회의실 사용해야함! => 회의의 최대 개수를 찾아보자
	 * 회의의 시작시간과 끝나는 시간이 같을 수 있다. => 시작하자마자 회의가 끝나는 것으로 간주
	 * 
	 * 
	 * 
	 * */

	
	static class MeetingRoom implements Comparable<MeetingRoom>{
		int no,start,end; //회의실 번호, 시작,종료 시간

		public MeetingRoom(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(MeetingRoom arg0) {
			int diff = this.end-arg0.end; //종료시간 기준으로 오름차순 정렬
			return diff!=0?diff:this.start-arg0.start; //종료시간이 같다면 시작 시간으로 정렬
		}

		@Override
		public String toString() {
			return "MeetingRoom [no=" + no + ", start=" + start + ", end=" + end + "]";
		}
		
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		MeetingRoom[] m = new MeetingRoom[N];
		
		
		for(int i=0;i<N;i++) {
			
			
			st = new StringTokenizer(br.readLine());
			m[i] = new MeetingRoom(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			
		}
		
//		List<MeetingRoom> list = getSchedule(m);
//		for(MeetingRoom meetingRoom : list) {
//			System.out.println(meetingRoom);
//		}
		int ans = getCnt(m);
		System.out.println(ans);
		
	}
	
	//정상 동작하는지 회의실 결과 출력하기 위함
	//만약 배정된 회의의 개수만 원한다면 리스트 사용 필요X 그냥 카운트만 하면 됨!
//	public static List<MeetingRoom> getSchedule(MeetingRoom[] m){
//		
//		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>(); //사용할 수 있도록 배정된 회
//		
//		Arrays.sort(m);
//		list.add(m[0]); //첫번째 회의는 무조건 배정
//		
//		for(int i=1,size=m.length;i<size;i++) {
//			if(list.get(list.size()-1).end<=m[i].start) {
//				//리스트에 배정되어 있는 마지막 회의보다 현재 내가 가지고 있는 회의 시작시간보다 내가 크거나 같다!
//				//그러면 리스트에 배정 가능
//				list.add(m[i]);
//				
//			}
//		}
//		
//		return list;
//	}
	
	public static int getCnt(MeetingRoom[] m) {
		
		Arrays.sort(m);
		int endTime = m[0].end;
		int cnt=1;
		for(int i=1,size=m.length;i<size;i++) {
			if(endTime<=m[i].start) {
				endTime=m[i].end;
				cnt++;
			}
		}
	
		return cnt;
	}

}
