import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end = Arrays.stream(diffs).max().getAsInt();
        
        while(start <= end){
            int level = (start+end)/2;
            long total_time = calculateTime(level, diffs, times);
            
            if(total_time <= limit){
                answer = level;
                end = level-1;
            }else{
                start = level+1;
            }
        }
        
    
        return answer;
    }
    
    long calculateTime(int middle_level, int[] diffs, int[] times){
        long time = 0; 
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= middle_level) time += times[i];
            else{
                time += (diffs[i]-middle_level)*(times[i]+times[i-1]) + times[i];
            }
        }
        return time;
    }
    
}