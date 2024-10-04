import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if(!isOdd(n)) return 0;     // 홀수는 무조건 0
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            Stack<String> stack = new Stack<>();
            
            int cnt = i;
            
            for(int j = 0; j < n; j++){
                if(cnt >= n) cnt = 0;
                
                if((s.charAt(cnt) == ')' || s.charAt(cnt) == '}' || s.charAt(cnt) == ']') && !stack.empty()){
                    if(stack.peek().equals("(") && s.charAt(cnt) == (')')) stack.pop();
                    else if(stack.peek().equals("{") && s.charAt(cnt) == '}') stack.pop();
                    else if(stack.peek().equals("[") && s.charAt(cnt) == ']') stack.pop();
                    
                }else{
                    stack.add(String.valueOf(s.charAt(cnt)));
                }
                cnt++;
            }
            if (stack.empty()) {
                answer++;
            }
        }
        
        
        return answer;
    }
    public boolean isOdd(int i){
        if(i%2==1) return false; 
        return true;
    }
}