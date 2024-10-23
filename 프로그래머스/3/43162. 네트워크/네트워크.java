import java.util.*;

class Solution {
    static int n;
    static int [][] computers;
    static boolean [] visited;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }   
        
        return answer;
    }
    
    void dfs(int node){
        for(int i = 0; i < n; i++){
            if(node == i) continue;
            if(computers[node][i] == 1 & !visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}