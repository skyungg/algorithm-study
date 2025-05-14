import java.util.*;

/*
아이디어: 조합/백트래킹/ 완탐
조합 -> 시간복잡도 (O(2^10^6)) -> 시간초과 발생
그리디 -> pq에 무적권 인원 넣어서 최대 라운드를 구하기
*/ 

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < enemy.length; i++){
            pq.add(enemy[i]);   // 무적권 사용
            
            if(pq.size() > k){
                int cnt = pq.poll();    // 가장 작은 값 꺼내기
                
                if(n < cnt) break;
                n -= cnt;
            }
            answer++;
        }
        return answer;
    }
    
   
}