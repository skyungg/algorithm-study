import java.util.*;

class Solution {
    boolean [][] visited;
    public int[] solution(String[] maps) {
        int [][] map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) == 'X'){
                    map[i][j] = -1;
                }else{
                    map[i][j] = Integer.parseInt(Character.toString(maps[i].charAt(j)));
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == -1 || visited[i][j]) continue;
                int tmp = bfs(i, j, map);
                if(tmp != 0){
                    result.add(tmp);
                }
            }
        }
        
        if(result.size() == 0){
            return new int[]{-1};
        }else{
            int [] answer = new int[result.size()];
            Collections.sort(result);
            for(int r = 0; r < result.size(); r++){
                answer[r] = result.get(r);
            }
            return answer;
        }     
    }
    
    int bfs(int x, int y, int [][] map){
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};
        
        Queue<int []> que = new LinkedList<>();
        que.add(new int[]{x, y});
        
        int result = map[x][y];
        visited[x][y] = true;
        int n = map[x].length;
        
        while(!que.isEmpty()){
            int [] tmp = que.poll();
            
            for(int i = 0 ; i < 4; i++){
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];
                
                if(tx < 0 || tx >= map.length || ty < 0 || ty >= n) continue;
                if(map[tx][ty] == -1 || visited[tx][ty]) continue;
                visited[tx][ty] = true;
                que.add(new int[]{tx, ty});
                result += map[tx][ty];
            }
        }
        
        return result;
        
    }
}