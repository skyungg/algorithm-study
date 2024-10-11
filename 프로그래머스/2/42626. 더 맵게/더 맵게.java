import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }

        while(pq.size() > 1 && pq.peek() < K){
            int fidx = pq.poll();
            int sidx = pq.poll();
            
            int tmp = fidx + (sidx*2);
            pq.offer(tmp);
            answer++;
            
        }
        if(pq.peek() < K) answer = -1;
        
        return answer;
    }
}