/*
아이디어: 아스키코드 기준으로 그리디?

*/

import java.util.*;

class Solution {
    public int solution(String name) {
        int n = name.length();
        int move = n-1; // 좌우 이동 횟수
        int cnt = 0;    // 알파벳 조작 횟수
        
        for(int i = 0; i < n; i++){
            char ch = name.charAt(i);
            
            // 1. 알파벳 조작
            cnt += Math.min(ch-'A', 'Z'-ch+1);   // ch가 'A'여도 암시롱
                // if(ch-'A' > 13){
                //     answer += ('Z'- ch);
                //     answer++;   // 이전 알파벳 조이스틱 작동
                // }else{
                //     answer += ch-'A';
                // }
            
            // 2. 알파벳 A가 끝나는 지점 찾기
            int index = i+1;
            while(index < n && name.charAt(index) == 'A'){
                index++;
            }
            
            // 3. 좌우 이동 최소 횟수 구하기
            move = Math.min(move, i*2 + n - index);     // 순서대로
            move = Math.min(move, (n-index)*2 + i);     // 뒤로 돌아가기
        }
        
        return cnt+move;
    }
}