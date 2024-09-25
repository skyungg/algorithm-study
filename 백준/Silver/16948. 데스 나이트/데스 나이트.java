import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [][] map;
    static int [] dx = {-2, -2, 0, 0, 2, 2};
    static int [] dy = {-1, 1, -2, 2, -1, 1};


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        for(int [] i : map){
            Arrays.fill(i, Integer.MAX_VALUE);      // 배열의 원소 값을 모두 최대값으로 채우기
        }
        map[ex][ey] = Integer.MAX_VALUE;
        bfs(sx, sy, ex, ey);


        if(map[ex][ey] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(map[ex][ey]);

    }

    static void bfs(int sx, int sy, int ex, int ey){
        Queue<int []> que = new LinkedList<>();
        boolean [][] visited = new boolean[n][n];
        visited[sx][sy] = true;
        map[sx][sy] = 0;
        que.add(new int[] {sx, sy});

        while(!que.isEmpty()){
            int [] tmp = que.poll();
            if(tmp[0] ==  ex  && tmp[1] == ey) break;

            for(int i = 0; i < dx.length; i++){
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];

                if(!isRange(tx, ty)) continue;      // 범위 밖
                if(map[tx][ty] != Integer.MAX_VALUE) continue;

                map[tx][ty] = Math.min(map[tx][ty], map[tmp[0]][tmp[1]] + 1);
                visited[tx][ty] = true;
                que.add(new int[]{tx, ty});

            }
        }
    }




    static boolean isRange(int i, int j){
        if(i >= 0 && i < n && j >= 0 && j < n) return true;
        return false;
    }
}
