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

    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][m];
        Queue<Point> que = new LinkedList<>();
        boolean [][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(num == 2){
                    que.add(new Point(i, j));
                    arr[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};


        while(!que.isEmpty()){
            Point p = que.poll();

            for(int i = 0; i < 4; i++){
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];

                if(tx < 0 || tx >= n || ty < 0 || ty >= m) continue;
                if(arr[tx][ty] == 0) continue;
                if(visited[tx][ty]) continue;

                arr[tx][ty] = arr[p.x][p.y] + 1;
                visited[tx][ty] = true;
                que.add(new Point(tx, ty));
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    System.out.print("-1 ");
                }else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
