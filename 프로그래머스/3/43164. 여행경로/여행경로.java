import java.util.*;

class Solution {
    static HashMap<String, PriorityQueue<String>> hmap = new HashMap<>();
    static LinkedList<String> route = new LinkedList<>();  // 경로 저장
    
    public String[] solution(String[][] tickets) {
        for(int i = 0; i < tickets.length; i++){
            hmap.putIfAbsent(tickets[i][0], new PriorityQueue<>());
            hmap.get(tickets[i][0]).offer(tickets[i][1]);
        }
        
        dfs("ICN");
        
        
        return route.toArray(new String[route.size()]);
    }
    
    void dfs(String key){
        while(hmap.containsKey(key) && !hmap.get(key).isEmpty()){
            String nextKey = hmap.get(key).poll();
            dfs(nextKey);
        }
        route.addFirst(key);
        
    }
}