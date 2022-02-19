package solution113;
// You may use import as below.
//import java.util.*;

class Solution {
    public int solution(String pos) {
        // Write code here.
    	
    	int x = pos.charAt(1)-'0';
    	int y = pos.charAt(0)-'A'+1;
    	
    	//8방 탐색
    	int[] di = {-1,-2,-2,-1,1,2,2,1}; //왼상 -> 시계방향
    	int[] dj = {-2,-1,1,2,2,1,-1,-2};
    	
    	int cnt = 0;
    	
    	for(int d=0;d<8;d++) {
    		int ni = x + di[d];
    		int nj = y + dj[d];
    		
    		if(ni<=0||nj<=0||ni>=9||nj>=9) continue;
    		
    		cnt++;
    		
    	}
    	
        int answer = cnt;
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String pos = "A7";
        int ret = sol.solution(pos);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}