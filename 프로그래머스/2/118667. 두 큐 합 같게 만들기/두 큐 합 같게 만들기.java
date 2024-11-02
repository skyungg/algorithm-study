import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int n = queue1.length;  // 큐 하나 길이
        
        long que1_sum = 0;
        long que2_sum = 0;
        for(int num : queue1) que1_sum += num;
        for(int num : queue2) que2_sum += num;
        long total_que = que1_sum + que2_sum;
        
        if(total_que%2 != 0) return -1; // 합의 절반이 홀수일 경우
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : queue1) list.add(num);
        for(int num : queue2) list.add(num);
        
        long target = total_que/2;
        
        int start = 0;      // queue1의 시작 인덱스
        int end = n;        // queue2의 시작 인덱스
        
        while(que1_sum != target){  // 합이 절반 되기 전까지 반복
            if(que1_sum > target){
                que1_sum -= list.get(start);
                start++;
            }else{
                que1_sum += list.get(end);
                end++;
            }
            answer++;
            
            if(start >= 2*n || end >= 2*n) return -1;
        }
        
        return answer;
    }
}