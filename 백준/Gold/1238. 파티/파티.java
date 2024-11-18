import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point>{
        int v;
        int time;

        public Point(int v, int time){
            this.v = v;
            this.time = time;
        }

        @Override
        public int compareTo(Point o){
            return this.time - o.time;
        }
    }

    static int[] start;
    static int[] end;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Point>> map = new ArrayList<>();
        ArrayList<ArrayList<Point>> rMap = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());   // 학생 수
        int m = Integer.parseInt(st.nextToken());   // 도로 수
        int x = Integer.parseInt(st.nextToken());   // 파티 장소

        for(int i = 0; i <= n; i++){
            map.add(new ArrayList<>());
            rMap.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(new Point(b, c));
            rMap.get(b).add(new Point(a, c));
        }

        start = dijkstra(map, x, n);     // 모든 집 -> 파티장소
        end = dijkstra(rMap, x, n);     // 파티장소 -> 모든 집


        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer = Math.max(answer, start[i]+end[i]);
        }
        System.out.println(answer);
    }
    static int [] dijkstra(ArrayList<ArrayList<Point>> graph, int x, int n){
        int [] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[x] = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(x, 0));

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            if (p.time > result[p.v]) continue;

            for (Point next : graph.get(p.v)) {
                if (result[next.v] > p.time + next.time) {
                    result[next.v] = p.time + next.time;
                    pq.add(new Point(next.v, result[next.v]));
                }
            }
        }

        return result;
    }
}
