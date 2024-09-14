import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= n; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        int [] result = bfs(graph, r, n);
        for(int i = 1; i <= n; i++){
            System.out.println(result[i]);
        }
    }

    static int[] bfs(ArrayList<ArrayList<Integer>> graph, int r, int n){
        int [] result = new int[n+1];
        boolean visited[] = new boolean[n+1];

        Queue<Integer> que = new LinkedList<Integer>();
        que.add(r);
        int cnt = 1;
        result[r] = cnt++;
        visited[r] = true;

        while(!que.isEmpty()){
            int num = que.poll();
//            Collections.sort(graph.get(num), Collections.reverseOrder());

            for(int next : graph.get(num)){
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = cnt++;
                    que.add(next);
                }
            }
        }

        return result;
    }
}
