import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int N = answers.length;
        
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] count = new int[3];
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max = -1;
        
        for(int i=0;i<N;i++){
            int num =answers[i];
            if(num==supo1[i%supo1.length]) max=max<(++count[0])?count[0]:max;
            if(num==supo2[i%supo2.length]) max=max<(++count[1])?count[1]:max;
            if(num==supo3[i%supo3.length]) max=max<(++count[2])?count[2]:max;
        }
        
        for(int i=0;i<3;i++){
            if(max==count[i]) list.add(i+1);
        }

        
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }

}