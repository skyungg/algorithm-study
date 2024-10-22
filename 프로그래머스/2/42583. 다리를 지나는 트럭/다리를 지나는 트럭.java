import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int []> que = new LinkedList<>();     // (트럭 무게, 다리에 오른 시간)
        int total_time = 0;     // 경과 시간
        int cur_weight = 0;     // 다리 위 트럭 무게 총 합
        int idx = 0;    // 대기 중인 트럭의 인덱스
        
        while(idx < truck_weights.length || !que.isEmpty()){
            total_time++;   // 먼저 매초 시간 증가
            
            if(!que.isEmpty() && total_time - que.peek()[1] >= bridge_length){
                cur_weight -= que.poll()[0];
            }
            
            if(idx < truck_weights.length && cur_weight + truck_weights[idx] <= weight){
                que.add(new int[]{truck_weights[idx], total_time});
                cur_weight += truck_weights[idx];
                idx++;  // 다음 트럭으로
            }
        }
        
        return total_time;
    }
}