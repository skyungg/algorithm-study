import java.util.*;

/*
아이디어: 완탐? - 조합
-> 1. 5개 조합 만들기

*/
class Solution {
    int n;
    int [][] q;
    int [] ans;
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
    
        combine(1, 0, new ArrayList<>());
        
        return answer;
    }
    
    void combine(int start, int cnt, List<Integer> combination){
        if(cnt == 5){
            // 5개 비밀 코드 완성
            checkPath(combination);
            return;
        }
        
        // 각 path별로 조합 만들기
        for(int i = start; i <= n; i++){
            combination.add(i);
            combine(i+1, cnt+1, combination);
            combination.remove(combination.size()-1);
        }
    }
    
    void checkPath(List<Integer> path){
        Set<Integer> set = new HashSet<>(path);
        
        for(int i = 0; i < ans.length; i++){
            // q안에서 검증하기
            int count = 0;
            
            for(int num : q[i]){
                if(set.contains(num)) count++;
            }
            
            // 현재 검출된 숫자와 ans의 검출값 일치 여부 확인
            if(ans[i] != count) return;
        }
        
        answer++;
    }
}