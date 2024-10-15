import java.util.*;

class Solution {
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    static char map [][];
    static class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(String[] maps) {
        int sx = 0;
        int sy = 0;
        int ex = 0;
        int ey = 0;
        int lx = 0;
        int ly = 0;
        n = maps.length;
        m = maps[0].length();
        
        
        map = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }else if(map[i][j] == 'E'){
                    ex = i;
                    ey = j;
                }else if(map[i][j] == 'L'){
                    lx = i;
                    ly = j;
                }
            }
        }

        int startToLever = bfs(sx, sy, lx, ly);
        if(startToLever == -1) return -1;
        
        int leverToExit = bfs(lx, ly, ex, ey);
        if(leverToExit == -1) return -1;
        
        return startToLever+leverToExit;
    }
    
    int bfs(int sx, int sy, int targetX, int targetY){
        Queue<Point> que = new LinkedList<>();
        boolean [][] visited = new boolean[n][m];
        int dis [][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        
        que.add(new Point(sx, sy));
        visited[sx][sy] = true;
        dis[sx][sy] = 0;
        
        while(!que.isEmpty()){
            Point p = que.poll();
            
            for(int i = 0; i < 4; i++){
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                
                if(isRange(tx, ty) && !visited[tx][ty]){
                    if(map[tx][ty] == 'X') continue;
                    if(dis[tx][ty] > dis[p.x][p.y]+1){
                        dis[tx][ty] = dis[p.x][p.y]+1;
                        que.add(new Point(tx, ty));
                    }
                    
                    if(tx == targetX && ty == targetY) return dis[tx][ty];
                }
            }
        }
        return -1;
    }
    
    boolean isRange(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        return true;
    }
}