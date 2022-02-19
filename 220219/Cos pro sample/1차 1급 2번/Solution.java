import java.util.Arrays;


// You may use import as below.

class Solution {
    public int solution(int n) {
        // Write code here.

        int[][] arr= new int[n][n];
        int sum = 0;

        int[] di = {0,1,0,-1};//우,하,좌,상
        int[] dj = {1,0,-1,0};
        int dir = 0;//오른쪽 방향으로 시작
        //n-소용돌이
        int ni=0,nj=0;
        int nowi=0,nowj=0;
        int cnt=1;
        while(true){

            nowi = ni;
            nowj = nj;
            arr[nowi][nowj]=cnt;
            if(cnt==n*n) break;


            ni = ni + di[dir];
            nj = nj + dj[dir];


            if(ni>=n||nj>=n||ni<0||nj<0||arr[ni][nj]!=0) {
                ni = nowi;
                nj = nowj;
                dir = (dir+1)%4;
                continue;
            }
            cnt++;

            //범위를 넘지않았고 방향을 바꾼 상태에서 다른 곳이 0이 아니라면 break;

        }
        
        for(int i=0;i<n;i++) {
        	System.out.println(Arrays.toString(arr[i]));
        }

        //대각선상 계산
        for(int i=0;i<n;i++){
            sum+=arr[i][i];
        }

        int answer = sum;
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 4;
        int ret1 = sol.solution(n1);

        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret1 + " .");
        
        int n2 = 2;
        int ret2 = sol.solution(n2);
        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}