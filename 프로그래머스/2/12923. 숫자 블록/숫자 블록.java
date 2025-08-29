import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int len = (int) (end-begin)+1;
        int [] answer = new int[len];
        
        for(long i = begin; i <= end; i++){
            if(i == 1){     // 블록 1인 경우 -> 0
                answer[(int)(i-begin)] = 0;
                continue;
            }
            
            answer[(int)(i-begin)] = findBlock(i);  // 현재 구간값의 약수중 가장 큰 값 찾기
            
        }
        
        return answer;
    }
    
    int findBlock(long target){
        int result = 1; // 기본값 (target 제외 큰 약수 구할 수 없음)
        
        for (long j = 2; j * j <= target; j++) {
            if (target % j == 0) {
                long pair = target / j;

                if (pair <= 10000000) {
                    return (int) pair;  // 가장 큰 블록을 바로 찾음
                }

                // pair는 너무 크면 안되지만 j는 괜찮으면 후보로 둔다
                result = (int) j;
            }
        }
        // 못 찾았으면 1 리턴
        return result;
    }
}