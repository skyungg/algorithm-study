import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<int []> que = new LinkedList<>();
        que.add(new int[] {x, 0});  // (값, 연산횟수)
        
        boolean[] visited = new boolean[y+1];   // 중복 방지
        visited[x] = true;
        
        while(!que.isEmpty()){
            int [] cur = que.poll();
            
            if(cur[0] == y){          // 연산한 값이 y일때
                return cur[1];  
            }
            
            int [] calculate = {cur[0]+n, cur[0]*2, cur[0]*3};
            
            for(int cal : calculate){
                if(cal > y || visited[cal]) continue;
                
                que.add(new int[] {cal, cur[1]+1});
                visited[cal] = true;
            }
        }
        
        return -1;
    }
}