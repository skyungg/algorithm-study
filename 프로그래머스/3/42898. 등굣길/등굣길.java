import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        
        int [][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        
        boolean isPud [][] = new boolean[n+1][m+1];
        
        for(int [] pud : puddles){
            isPud[pud[1]][pud[0]] = true;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(i == 1 && j == 1) continue;      // 시작점 해당 안 됨
                if(isPud[i][j]){
                    dp[i][j] = 0;    // 물 웅덩이는 해당 안 됨
                }else{
                    int left = 0;
                    int top = 0;
                    
                    if(i > 1) left = dp[i-1][j];
                    if(j > 1) top = dp[i][j-1];
                    dp[i][j] = (left + top) % mod;
                }
            }
        }
        
        return  dp[n][m];
    }
}