import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        boolean flag = false;
        
        for(int i = 0 ; i < order.length; i++){
            if(order[i] == idx){
                answer++;
                idx++;
                flag = true;
            }else{
                if((stack.size() > 0) && (stack.peek() == order[i])){
                    stack.pop();
                    answer++;
                    flag = true;
                }else{
                    while(idx < order.length){
                        stack.add(idx++);
                        if(order[i] == idx){
                            answer++;
                            idx++;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(!flag)break;
            else flag = false;
        }
        
        return answer;
    }
}