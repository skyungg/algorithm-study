/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1, graph, new boolean[n+1], n);

    }

    static void bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean [] visited, int n){
        visited[start] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        int count = 0;

        while(!que.isEmpty()){
            int num = que.poll();

            for(int i = 0; i < graph.get(num).size(); i++){
                if(visited[graph.get(num).get(i)]) continue;
                count++;
                visited[graph.get(num).get(i)] = true;
                que.add(graph.get(num).get(i));
            }
        }
        System.out.println(count);
    }
}
