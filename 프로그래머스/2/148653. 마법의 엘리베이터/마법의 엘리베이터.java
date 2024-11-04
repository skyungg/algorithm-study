import java.util.*;

class Solution {
    public int solution(int storey) {
        int count = 0;  // 이동 횟수
        
        while(storey > 0){
            int digit = storey%10;  // 현재 자릿수
            int next_digit = (storey/10)%10;
            
            if(digit < 5){             // 5미만 -> 감소
                count += digit;
                storey /= 10;
            }else if(digit > 5){       // 5이상 -> 증가
                count += (10-digit);
                storey = (storey/10) + 1;
            }else{
                // 5일경우
                if(next_digit >= 5){
                    count += (10-digit);
                    storey = (storey/10) + 1;
                }else{
                    count += digit;
                    storey /= 10;
                }
            }
        }
        
        return count;
    }
}