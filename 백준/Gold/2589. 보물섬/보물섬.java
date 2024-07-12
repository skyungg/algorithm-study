
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;





public class Main {
    static class Point{
        public int i, j, w;
        Point(int i, int j, int w){
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }

    static int n;              // 행 크기
    static int m;              // 열 크기
    static int [][] map;       // 보물섬 지도
    static int maxD;           // 보물섬 사이의 최단 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            String arr[] = br.readLine().split("");
            for(int j = 0; j < m; j++){
                if(arr[j].equals("W")){     // 바다
                    map[i][j] = 1;
                }else{
                    map[i][j] = 0;      //육지
                }
            }
        }

        maxD = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    bfs(i, j);
                }
            }
        }

        System.out.print(maxD-1);
    }


    static void bfs(int i, int j){
        boolean [][] visited = new boolean[n][m];
        Queue<Point> que = new LinkedList<Point>();
        que.add(new Point(i, j, 1));
        visited[i][j] = true;

        while(!que.isEmpty()){
            Point p = que.poll();
            int x = p.i;
            int y = p.j;
            int w = p.w;

            int dx[] = {0, 1, 0, -1};       // 우하좌상
            int dy[] = {1, 0, -1, 0};

            for(int d = 0; d < dx.length; d++){
                int nx = dx[d] + x;
                int ny = dy[d] + y;

                if(nx < 0 || nx >= n || ny < 0 || ny >= m){     // 범위 밖
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny] == 0){      // 아직 방문 전, 육지
                    visited[nx][ny] = true;
                    que.add(new Point(nx, ny, w+1));

                    if(w+1 > maxD){
                        maxD = w+1;
                    }
                }
            }
        }

    }
}
