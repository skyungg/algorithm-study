import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Character [][] list = new Character[n][m];

        int sx = 0;
        int sy = 0;

        for(int i = 0;i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                list[i][j] = line.charAt(j);
                if (list[i][j].equals('I')){
                    sx = i;
                    sy = j;
                }

            }
        }

        Queue<int []> que = new LinkedList<>();
        boolean [][] visited = new boolean[n][m];
        que.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};
        int count = 0;

        while(!que.isEmpty()){
            int [] tmp = que.poll();

            for(int i = 0; i < 4; i++){
                int tx = tmp[0] + dx[i];
                int ty = tmp[1] + dy[i];

                if((tx >= 0 && tx < n && ty >= 0 && ty < m) && !visited[tx][ty]){
                    if(list[tx][ty].equals('P')){
                        count++;
                        visited[tx][ty] = true;
                        que.add(new int[]{tx, ty});
                    }else if(list[tx][ty].equals('O')){
                        visited[tx][ty] = true;
                        que.add(new int[]{tx, ty});
                    }
                }
            }
        }
        if(count==0) System.out.println("TT");
        else System.out.println(count);
    }
}
