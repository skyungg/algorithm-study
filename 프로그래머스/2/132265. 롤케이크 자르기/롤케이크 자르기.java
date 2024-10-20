import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int count = 0;
        
        Set<Integer> leftSet = new HashSet<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        
        for(int tp : topping){
            rightMap.put(tp, rightMap.getOrDefault(tp, 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++){
            int tp = topping[i];
            
            leftSet.add(tp);    // 철수 토핑 추가
            
            rightMap.put(tp, rightMap.get(tp)-1);   // 동생 토핑 감소
            if(rightMap.get(tp) == 0){
                rightMap.remove(tp);
            }
            
            if(leftSet.size() == rightMap.size()) answer++;
        }
        
        return answer;
    }
}