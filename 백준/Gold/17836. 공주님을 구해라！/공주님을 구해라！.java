import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int [][] map;
    static int [][] time;
    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        time = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if(time[n-1][m-1] > t || time[n-1][m-1] == 0){
            System.out.println("Fail");
        }else{
            System.out.println(time[n-1][m-1]);
        }
    }

    static void bfs(){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0));
        time[0][0] = 0;
        boolean flag = false;

        while(!que.isEmpty()){
            Point p = que.poll();

            int [] dx = {-1, 0, 1, 0};
            int [] dy = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++){
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];

                if(tx < 0 || tx >= n || ty < 0 || ty >= m) continue;
                if(map[tx][ty] == 1) continue;
                if(map[tx][ty] == 2){
                    if(time[n-1][m-1] == 0){
                        time[n-1][m-1] = time[p.x][p.y] + 1 + ((n-1) - tx) + ((m-1) - ty);
                    }else{
                        time[n-1][m-1] = Math.min(time[n-1][m-1], time[p.x][p.y] + 1 + ((n-1) - tx) + ((m-1) - ty));
                    }
                    continue;
                }
                if(time[tx][ty] == 0){
                    time[tx][ty] = time[p.x][p.y] + 1;
                    que.add(new Point(tx, ty));
                }else{
                    if(time[p.x][p.y] + 1 < time[tx][ty]){
                        time[tx][ty] = time[p.x][p.y] + 1;
                        que.add(new Point(tx, ty));
                    }
                }
            }

        }

    }
}
