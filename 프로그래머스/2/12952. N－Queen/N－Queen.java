import java.util.*;

/*
아이디어: 백트래킹
1) 퀸은 한 행에 하나만 두기
2) n행에 다 두고 판단하기
*/
class Solution {
    int n;
    int answer = 0;    
    public int solution(int n) {
        this.n = n;
        dfs(0, new int[n]);
        return answer;
    }
    
    void dfs(int cnt, int [] col){
        if(cnt == n){
            answer++;   // N-Queen 만족
            return;
        }
        
        for(int i = 0; i < n; i++){
            col[cnt] = i;
            if(isValid(col, cnt)) dfs(cnt+1, col);
        }
    }
    
    boolean isValid(int [] col, int cnt){
        for(int i = 0; i < cnt; i++){
            if(col[i] == col[cnt] || Math.abs(col[cnt] - col[i]) == cnt - i){
                // 같은 열 위치 or 대각선에 위치하는 경우 -> N-Queen 조건 X
                return false;
            }
        }
        return true;
    }


}
