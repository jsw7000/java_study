import java.util.*;
public class Solution {

    public int[] solution(int[] answers) {
        int[] answer = {};
        int N = answers.length;
        int[] supo1 = new int[N];
        int[] supo2 = new int[N];
        int[] supo3 = new int[N];
        
        answer = supo(N,answers,supo1,supo2,supo3);
        
        return answer;
    }
/*    
    public static int[] supo(int N,int[] answers,int[] supo1,int[] supo2,int[] supo3){
        
        for(int i=0;i<N;i++){
            supo1[i] = (i%5)+1;
        }
        
        int num =1;
        for(int i=0;i<N;i++){
            if(i%2==0){
                supo2[i] = 2;
            }else{
                supo2[i]=num++;
                if(num==2) num++;
                if(num==6) num=1;
            }
            System.out.println(supo2[i]);
        }
        
        int cnt=2;
        num=0;
        for(int i=0;i<N;i++){
            
            //cnt가 0인경우
            if(cnt==0){
                cnt=2;
                num=(++num%6);
                if(num==3) num++;
            }
            
            if(num==0){
                supo3[i] = 3;
                cnt--;
            }else{
                supo3[i] = num;
                cnt--;
            }
            
            // System.out.println(supo3[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] count = new int[3];
        int max = -1;
        
        for(int i=0;i<N;i++){
            int answer = answers[i];
            if(answer==supo1[i]) {
                count[0]++;
                max = max<count[0]?count[0]:max;
            }
            if(answer==supo2[i]) {
                count[1]++;
                max = max<count[1]?count[1]:max;
            }
            if(answer==supo3[i]) {
                count[2]++;
                max = max<count[2]?count[2]:max;
            }
            
        }
        
        //list 삽입
        for(int i=0;i<3;i++){
            if(max==count[i]){
                list.add(i+1);
            }
        }
        
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
         result[i]=list.get(i);   
        }
        //오름차순 정렬
        Arrays.sort(result);
        
        return result;
    }
}
