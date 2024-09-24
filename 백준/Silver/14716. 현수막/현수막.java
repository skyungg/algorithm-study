import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int [] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void bfs(int i, int j){
        Queue<Point> que = new LinkedList<>();
        visited[i][j] = true;
        que.add(new Point(i, j));

        while(!que.isEmpty()){
            Point p = que.poll();

            for(int idx = 0; idx < 8; idx++){
                int tx = p.x + dx[idx];
                int ty = p.y + dy[idx];

                if(!isRange(tx, ty)) continue;
                if(!visited[tx][ty] && map[tx][ty] == 1){
                    visited[tx][ty] = true;
                    que.add(new Point(tx, ty));
                }
            }
        }
    }

    static boolean isRange(int i, int j){
        if(i >= 0 && i < m && j >= 0 && j < n) return true;
        return false;
    }
}
