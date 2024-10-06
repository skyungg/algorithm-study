import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> hmap = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            if(hmap.containsKey(clothes[i][1])){
                hmap.get(clothes[i][1]).add(clothes[i][0]);
            }else{
                hmap.put(clothes[i][1], new ArrayList<>());
                hmap.get(clothes[i][1]).add(clothes[i][0]);
            }
        }
        
        if(hmap.size() == 1){
            for(String key : hmap.keySet()){
                answer = hmap.get(key).size();
            }
            
        }else{
            for(String key : hmap.keySet()){
                answer *= (hmap.get(key).size() + 1);
            }
            answer--;
        }
        
        return answer;
    }
}