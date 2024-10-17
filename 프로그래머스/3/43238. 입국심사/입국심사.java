import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);     // 입국 심사 오름차순
        long end = (long) times[times.length - 1] * n;   // 최대 시간
        long start = 1;     // 최소 시간
        long answer = end;
        
        while(start <= end){
            long mid_time = (start + end) / 2;
            
            long num = 0;   // mid_time안에 각각 심사하는 사람 수
            for(int i = 0; i < times.length; i++){
                num += mid_time/times[i];
                
                if(num >= n) break;
            }
            
            if(num >= n){
                answer = Math.min(answer, mid_time);
                end = mid_time - 1;
            }else start = mid_time + 1;
        }
        
        return answer;
    }
}