import java.util.*;

/*
문제 이해
1. N을 이용해서 number 만들기
2. N의 최소 사용횟수를 구하는게 목표!
3. N은 최대 8번까지 사용 가능
4. 사칙연산 통해서 새로운 수 만들수 있음

* dp[i]가 의미하는 건?*
--> N을 i번 사용해서 만들 수 있는 숫자들의 집합


*/
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