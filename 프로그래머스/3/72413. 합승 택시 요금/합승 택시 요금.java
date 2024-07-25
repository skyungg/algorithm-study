import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
    int vex, cost;

    public Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }

    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

class Solution {
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;


        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        // 인접리스트 생성
        for(int i = 0; i < fares.length; i++){
            int p = fares[i][0]-1;
            int q = fares[i][1]-1;
            int cost = fares[i][2];

            graph.get(p).add(new Edge(q, cost));
            graph.get(q).add(new Edge(p, cost));
        }

        // 합승, A혼자, B혼자
        int [] together = dijkstra(s-1, new int[n]);
        int [] aloneA = dijkstra(a-1, new int[n]);
        int [] aloneB = dijkstra(b-1, new int[n]);

        for(int i = 0; i < n; i++){
            if(together[i] == Integer.MAX_VALUE || aloneA[i] == Integer.MAX_VALUE
                || aloneB[i] == Integer.MAX_VALUE){
                continue;
            }
            answer = Math.min(answer, together[i]+aloneA[i]+aloneB[i]);
        }

        return answer;
    }

    public int[] dijkstra(int start, int[] dis){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();

            int cur = tmp.vex;
            int curCost = tmp.cost;

            if(curCost > dis[cur]){
                continue;
            }

            for(Edge o : graph.get(cur)){
                if(dis[o.vex] > curCost + o.cost){
                    dis[o.vex] = curCost + o.cost;
                    pq.offer(new Edge(o.vex, dis[o.vex]));
                }
            }
        }
        return dis;
    }
}