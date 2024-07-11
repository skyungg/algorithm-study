
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int arr[][];
    static boolean visited[][];        // 방문 확인 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][n];

        bfs();

        if(visited[n-1][n-1]){
            System.out.print("HaruHaru");
        }else{
            System.out.print("Hing");
        }
    }
    static void bfs(){

        Queue<Point> que = new LinkedList<Point>();
        que.add(new Point(0,0));     // 초기 위치
//        visited[0][0] = true;   // 초기 위치 방문

        int dx[] = {1, 0};
        int dy[] = {0, 1};

        while(!que.isEmpty()){
            Point p = que.poll();

            int x = p.x;
            int y = p.y;
            int count = arr[x][y];

            if(count == -1){
                break;
            }

            for(int i = 0; i < dx.length; i++){
                int nx = dx[i] * count + x;
                int ny = dy[i] * count + y;

                if((nx >= 0 && nx < n && ny >= 0 && ny < n ) && !visited[nx][ny]){
                    que.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

}
