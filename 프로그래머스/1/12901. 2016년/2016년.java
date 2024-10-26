import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int [] info = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String [] day = {"FRI","SAT", "SUN","MON","TUE","WED","THU"};
        
        int total_day = b;
        
        for(int i = 1; i < a; i++){
            total_day += info[i];
        }
        
        
        answer = day[(total_day-1)%7];
        
        return answer;
    }
}