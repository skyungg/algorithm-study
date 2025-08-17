import java.util.*;

/*
아이디어 : 수학
-> 큰 원 - 작은 원
-> 1사분면 * 4
*/
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            long minValue = (long) Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*i*i));
            long maxValue = (long) Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*i*i));
 
            answer += (maxValue - minValue + 1);
        }
        
        return answer*4;
    }
}