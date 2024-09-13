import java.io.*;
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

        int [] result = bfs(graph, r, n);
        for(int res: result){
            System.out.println(res);
        }
    }

    static int[] bfs(ArrayList<ArrayList<Integer>> graph, int r, int n){
        int [] result = new int[n];
        boolean visited[] = new boolean[n];

        Queue<Integer> que = new LinkedList<Integer>();
        que.add(r);
        int cnt = 1;
        result[r-1] = cnt++;
        visited[r-1] = true;

        while(!que.isEmpty()){
            int num = que.poll();
            Collections.sort(graph.get(num));

            for(int next : graph.get(num)){
                if(!visited[next-1]){
                    visited[next-1] = true;
                    result[next-1] = cnt++;
                    que.add(next);
                }
            }
        }

        return result;
    }
}
