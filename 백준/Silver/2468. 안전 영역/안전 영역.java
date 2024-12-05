import java.io.*;
import java.util.*;

public class Main {
    static int maxCount = 1;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n][n];
        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, map[i][j]);
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        boolean [][] visited = new boolean [n][n];
        for(int h = minH; h <= maxH; h++){
            for (boolean[] row : visited) {
                Arrays.fill(row, false); // 초기화
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] > h && !visited[i][j]){
                        bfs(h, map, visited, n, i, j);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }

    static void bfs(int h, int [][] map, boolean [][] visited, int n, int x, int y){
        Queue<int []> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;

        int [] dx = {0, -1, 0, 1};
        int [] dy = {-1, 0, 1, 0};

        while(!que.isEmpty()){
            int [] tmp = que.poll();

            for(int i = 0; i < 4; i++){
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];

                if(tx < 0 || tx >= n || ty < 0 || ty >= n) continue;
                if(!visited[tx][ty] && map[tx][ty] > h){
                    visited[tx][ty] = true;
                    que.add(new int[]{tx, ty});
                }
            }
        }
    }
}
