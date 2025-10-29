import java.util.*;

/*
  (구) 각 지점 사이의 거리의 최솟값 중 가장 큰 값
  
*/
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        // 1. 정렬
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2; // 최소 거리 후보
            int removed = 0;              // 제거한 돌 개수
            int prev = 0;                 // 이전 돌의 위치

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removed++; // mid 거리보다 짧으면 돌 제거
                } else {
                    prev = rock; // 유지
                }
            }
            
            // 마지막 도착지점까지 확인
            if (distance - prev < mid) removed++;

            if (removed > n) {
                // 너무 많이 제거해야 함 → mid 줄이기
                right = mid - 1;
            } else {
                // 거리 늘릴 수 있음
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}