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

    static int [][] map;
    static boolean [][] visited;
    static int m;
    static int n;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
            }
        }
        String result = "NO";
        for(int i =  0; i < n; i++){
            if(map[0][i] == 1) continue;
            if(bfs(i)){
                result = "YES";
                break;
            };
        }

        System.out.println(result);

    }

    static boolean bfs(int i){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, i));
        visited[0][i] = true;
        boolean flag = false;
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};

        while(!que.isEmpty()){
            Point p = que.poll();

            for(int idx = 0; idx < 4; idx++){
                int tx = p.x + dx[idx];
                int ty = p.y + dy[idx];

                if(tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
                if(map[tx][ty] == 1) continue;
                if(visited[tx][ty]) continue;
                if(tx == m-1) return true;
                visited[tx][ty] = true;
                que.add(new Point(tx, ty));
            }
        }
        return flag;
    }
}
