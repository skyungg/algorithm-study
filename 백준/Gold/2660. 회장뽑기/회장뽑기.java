
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [] result;
    static boolean [][] arr;
    static int maxCnt;
    static int count;

    static class Point{
        int num;
        int cnt;

        public Point(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        result = new int[n];

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if(p == -1 && q == -1) {
                break;
            }
            arr[p-1][q-1] = true;       // 양방향 표시
            arr[q-1][p-1] = true;
        }

        count = 0;
        maxCnt = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            bfs(i);
        }

        sb.append(maxCnt + " " + count + "\n");
        for(int i = 0; i < n; i++){
            if(result[i] == maxCnt){
                sb.append(i+1 + " ");
            }
        }

        System.out.println(sb);

    }

    static void bfs(int idx){
        Queue<Point> que = new LinkedList<>();
        boolean [] visited = new boolean[n];
        que.add(new Point(idx, 0));
        visited[idx] = true;
        int tmp = 0;


        while(!que.isEmpty()){
            Point p = que.poll();
            int tcnt = p.cnt;

            for(int i = 0; i < n; i++){
                if(visited[i]) continue;

                if(arr[p.num][i]){
                    que.add(new Point(i, p.cnt+1));
                    visited[i] = true;
                    tcnt = p.cnt+1;
                }

                tmp = Math.max(tmp, tcnt);
            }
        }
        result[idx] = tmp;
        if(tmp < maxCnt){
            count = 1;
            maxCnt = tmp;
        }else if(tmp == maxCnt){
            count++;
        }
    }
}
