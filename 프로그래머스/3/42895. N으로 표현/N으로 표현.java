import java.util.*;

// 
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        Set<Integer> [] dp = new HashSet[9];    // n을 이용할 수 있는 최대횟수->8
        
        for(int i = 1; i < 9; i++){
            dp[i] = new HashSet<>();
            dp[i].add(repeatNum(i, N));     // i만큼 N 반복한 수
            
            // 점화식
            for(int j = 1; j < i; j++){
                for(int num1 : dp[j]){
                    for(int num2 : dp[i-j]){
                        dp[i].add(num1 + num2);     // 덧셈
                        dp[i].add(num1 - num2);     // 뺄셈
                        dp[i].add(num1 * num2);     // 곱셈
                        if(num2 != 0) dp[i].add(num1 / num2);     // 나눗셈
                    }
                }
            }
            
            if(dp[i].contains(number)) return i;
        
        }
        
        return -1;
    }
    
    int repeatNum(int i, int N){
        String str = "";
        for(int idx = 0; idx < i; idx++){
            str += N;
        }
        return Integer.parseInt(str);
    }
}