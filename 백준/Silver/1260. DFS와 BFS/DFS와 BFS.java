import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static List<Integer> list = new LinkedList<>();
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i = 0; i <= n; i++){
            Collections.sort(graph.get(i));     // 오름 차순 정렬
        }

        dfs(v, new boolean[n+1]);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)+" ");
        }
        sb.append("\n");
        bfs(v, new boolean[n+1], sb);
    }

    static void dfs(int start, boolean [] visited){
        if(!visited[start]){
            visited[start] = true;
            list.add(start);
        }

        for(int i = 0; i < graph.get(start).size(); i++){
            if(visited[graph.get(start).get(i)]) continue;
//            visited[graph.get(start).get(i)] = true;
            dfs(graph.get(start).get(i), visited);
        }
    }

    static void bfs(int start, boolean [] visited, StringBuilder sb){
//        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        sb.append(start+" ");

        while(!que.isEmpty()){
            int num = que.poll();

            ArrayList<Integer> tmpGraph = graph.get(num);
            for(int i = 0; i < tmpGraph.size(); i++){
                if(visited[tmpGraph.get(i)]) continue;
                que.add(tmpGraph.get(i));
                visited[tmpGraph.get(i)] = true;
                sb.append(tmpGraph.get(i)+" ");
            }
        }
        System.out.println(sb.toString());
    }
}
