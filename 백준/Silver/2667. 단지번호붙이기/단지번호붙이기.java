/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
 */

import java.io.*;
import java.util.*;

public class Main {
    static int [][] map;
    static boolean [][] visited;
    static int vcnt;
    static int [] dx = {0, -1, 0, 1};
    static int [] dy = {-1, 0, 1, 0};
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0) continue;
                if(visited[i][j]) continue;
                vcnt = 0;
                dfs(i, j, n);
                count++;
                list.add(vcnt);
            }
        }

        Collections.sort(list);
        System.out.println(count);
        for(int i : list){
            System.out.println(i);
        }
    }

    static void dfs(int x, int y, int n){
        vcnt++; // 마을 안 단지 수 증가
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int tx = x + dx[i];
            int ty = y + dy[i];

            if(checkRange(n, tx, ty) && !visited[tx][ty] && map[tx][ty] == 1) {
                dfs(tx, ty, n);
            }
        }
    }

    static boolean checkRange(int n, int tx, int ty){
        if(tx < 0 || tx >= n  || ty < 0 || ty >= n) return false;
        return true;
    }
}
