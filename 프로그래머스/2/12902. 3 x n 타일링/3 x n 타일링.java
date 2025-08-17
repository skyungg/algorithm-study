import java.util.*;
/*
 아이디어: 누가봐도 DP
 - 바닥은 짝수밖에 안 됨
 - dp[i] = 가로길이가 i인 경우의 수
*/

class Solution {
    public long solution(int n) {
        long [] dp = new long[n+1];
        dp[2] = 3;
        
        for(int i = 4; i <= n; i++){
            dp[i] = dp[i-2]*dp[2] + 2;
            
            for(int j = 2; j <= i-4; j+=2) {
                dp[i] += dp[j]*2;    
            }
            
            dp[i] = dp[i]%1000000007;
        }
        
        return dp[n];
    }
}