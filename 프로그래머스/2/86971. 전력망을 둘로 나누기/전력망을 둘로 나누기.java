import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList<>();
        
        for(int i = 0; i < n+1; i++){
            list.add(new ArrayList<>());
            // ArrayList<Integer> tmp_list = new ArrayList<>();
            // list.get(i).add(tmp_list);
        }
        
        for(int i = 0; i < wires.length; i++){
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }
        
        int minCount = Integer.MAX_VALUE;
        
        for(int i = 1; i < list.size(); i++){
            ArrayList<Integer> tmp = list.get(i);
            if(tmp.size() <= 1) continue;       // 연결된 노드가 1개 이하라면 패스
            for(int j = 0; j < tmp.size(); j++){
                minCount = Math.min(minCount, getCount(i, tmp.get(j), new boolean[n+1]));
            }
        }
        
        return minCount;
    }
    
    int getCount(int node, int target, boolean [] visited){
        int top_first = 0;
        int top_second = 0;
        visited[node] = true;
        visited[target] = true;     // 끊을 노드
        
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        que.add(node);
        que2.add(target);
        
        while(!que.isEmpty()){
            int cur_point = que.poll();
            ArrayList<Integer> tmp = list.get(cur_point);
            
            for(int i = 0; i < tmp.size(); i++){
                if(tmp.get(i) == target) continue;
                
                if(!visited[tmp.get(i)]){
                    visited[tmp.get(i)] = true;
                    top_first++;
                    que.add(tmp.get(i));
                }
            } 
        }
        
        
        while(!que2.isEmpty()){
            int cur_point = que2.poll();
            ArrayList<Integer> tmp = list.get(cur_point);
            
            for(int i = 0; i < tmp.size(); i++){
                if(tmp.get(i) == node) continue;
                
                if(!visited[tmp.get(i)]){
                    visited[tmp.get(i)] = true;
                    top_second++;
                    que2.add(tmp.get(i));
                }
            } 
        }
        // System.out.println("node : "+node+", target: "+target+" / "+top_first+", "+top_second);
        return Math.abs(top_first - top_second);
        
    }
}