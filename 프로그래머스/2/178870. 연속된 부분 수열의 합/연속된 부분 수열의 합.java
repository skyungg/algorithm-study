import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int maxValue = Integer.MAX_VALUE;
        int answer[] = {0, maxValue}; // 두 인덱스
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int n = sequence.length;

        while(start <= end && end < n){
            if(sum < k){
                end++;
                if(end == n) break;
                sum += sequence[end];
            }
            else if(sum > k){
                sum -= sequence[start];
                start++;
            }
            else{   // 값이 일치
               if(answer[1]-answer[0] > end-start){
                   answer[0] = start;
                   answer[1] = end;
               }
                sum -= sequence[start];
                start++;
            }
        }

        return answer;
    }
}