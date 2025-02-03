/*
아이디어 : 정렬
1. 정렬하기 (진입지점 오름차순, 진출지점 오름차순)
2. for문 돌며, 현재 진입지점이 이전 진출지점보다 크면 같은 영역, 다르면 증가
*/

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int curPoint = Integer.MIN_VALUE;  // 현재 카메라 위치
        
        for(int i = 0; i < routes.length; i++){
            if(routes[i][0] > curPoint){
                curPoint = routes[i][1];    // 비교는 진입, 갱신은 지출
                answer++;
            }
        }
        
        return answer;
    }
}