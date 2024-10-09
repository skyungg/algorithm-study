import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();       // 가격 인덱스 담기

        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){    // 가격 떨어짐
                int idx = stack.pop();
                answer[idx] = i - idx;  // 현재 떨어진 시점 인덱스 - 처음 시점 인덱스
                
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){    // 남아있는 stack 처리
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}