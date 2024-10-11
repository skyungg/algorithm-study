import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }

        while(!pq.isEmpty()){
            int fidx = pq.poll();
            if(fidx >= K) break;
            if(pq.isEmpty()) return -1;
            int sidx = pq.poll();
            
            int tmp = fidx + (sidx*2);
            pq.offer(tmp);
            answer++;
            
        }
        
        return answer;
    }
}