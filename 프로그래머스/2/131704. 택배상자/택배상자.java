import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        
        for(int i = 0 ; i < order.length; i++){
            stack.add(i+1);
            
            while(!stack.isEmpty()){
                if(stack.peek() == order[idx]){
                    stack.pop();
                    answer++;
                    idx++;
                }else break;
            }
        }
        
        return answer;
    }
}