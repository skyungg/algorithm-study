import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean [] visited;
    static List<Integer> [] list;
    static int [] result;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new List[n + 1];
        result = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for(int i = 1; i < n+1; i++){
            visited = new boolean[n+1];
            bfs(i);
        }

        int maxRow = Integer.MIN_VALUE;
        for(int i = 1; i < n+1; i++){
            maxRow = Math.max(maxRow, result[i]);
        }

        for(int i = 1; i < n+1; i++){
            if(result[i] == maxRow){
                System.out.print(i+" ");
            }
        }
    }

    static void bfs(int i){
            Queue<Integer> que = new LinkedList<>();
            que.add(i);

            visited[i] = true;

            while(!que.isEmpty()){
                int num = que.poll();
                for(int tmp : list[num]){
                    if(!visited[tmp]){
                        result[tmp]++;
                        visited[tmp] = true;
                        que.add(tmp);
                    }
                }
            }
    }
}
