import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    int maxSheep = 0;   // 양의 최댓값
    
    public int solution(int[] info, int[][] edges) {
        for(int i = 0; i < info.length; i++){
            list.add(new ArrayList<>());
        }
        
        for(int [] edge : edges){
            list.get(edge[0]).add(edge[1]); // 부모노드(edge[0]) 순서에 자식노드(edge[1]) 삽입
        }
        
        List<Integer> nextList = new ArrayList<>();
        nextList.add(0);    // 루트 노드부터 시작
        dfs(0, 0, 0, nextList, info);
        
        return maxSheep;
    }
    
    // 현재 양의 개수, 현재 늑대의 개수, 현재 노드, 다음 탐색 노드, 동물 정보
    void dfs(int sheep, int wolf, int cur_node, List<Integer> nextList, int [] info){
        // 1. 일단 동물 판단
        if(info[cur_node] == 0) sheep++;
        else wolf++;
        
        if(wolf >= sheep) return;    // 늑대 >= 양 종료
        
        maxSheep = Math.max(maxSheep, sheep);   // 양 최댓값 갱신
        
        List<Integer> newList = new ArrayList<>(nextList);  // 리스트 복사
        newList.remove(Integer.valueOf(cur_node));
        newList.addAll(list.get(cur_node));
        
        for (int next : newList) {
         dfs(sheep, wolf, next, new ArrayList<>(newList), info);
        }
    }
}