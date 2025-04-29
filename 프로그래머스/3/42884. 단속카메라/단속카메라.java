import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 정렬하기
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);    // 진출 기점 오름차순 정렬
        
        int target = routes[0][1];       // 진출을 기점으로 판단
        int answer = 1;
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] > target){
                answer++;
                target = routes[i][1];
            }   
        }
        
        return answer;
    }
}