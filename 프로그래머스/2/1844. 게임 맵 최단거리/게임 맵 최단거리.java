import java.util.*;

class Solution {
    int [][] cost;
    int n, m;
    int [] dx = {-1, 0, 1, 0};
    int [] dy = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        cost = new int[n][m];
        // 0. 비용 초기화
        for(int [] arr : cost){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        cost[0][0] = 1;
        bfs(maps);
        return cost[n-1][m-1] < Integer.MAX_VALUE ? cost[n-1][m-1] : -1;
    }
    
    void bfs(int [][] maps){
        Queue<int []> que = new LinkedList<>();
        que.add(new int[]{0, 0});   // 출발
        
        while(!que.isEmpty()){
            int [] cur = que.poll();
            
            for(int i = 0; i < 4; i++){
                int tx = cur[0] + dx[i];
                int ty =  cur[1] + dy[i];
                if(isRange(tx, ty) && maps[tx][ty] == 1){
                    if(cost[tx][ty] > cost[cur[0]][cur[1]]+1){
                        cost[tx][ty] = cost[cur[0]][cur[1]]+1;
                        que.add(new int[] {tx, ty});
                        
                    }
                }
            }
        }
    }
    
    boolean isRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}