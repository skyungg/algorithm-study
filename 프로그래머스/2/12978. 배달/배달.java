import java.util.*;

class Solution {
    ArrayList<ArrayList<int []>> list = new ArrayList<>();
    int times[];
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        times = new int[N+1];
        
        for(int i = 0; i < N+1; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            list.get(a).add(new int[]{b, c});
            list.get(b).add(new int[]{a, c});
        }
        
        dijkstra(N, K);
        
        for(int time : times){
            if(time <= K) answer++;
        }
        
        return answer;
    }
    
    void dijkstra(int N, int k){
        PriorityQueue<int []> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(times, Integer.MAX_VALUE);
        times[1] = 0;
        que.add(new int[]{1, 0});   // 현재 위치, 시간
        
        while(!que.isEmpty()){
            int [] cur_point = que.poll();
            
            ArrayList<int []> points = list.get(cur_point[0]);
            for(int i= 0; i < points.size(); i++){

                if(cur_point[1] + points.get(i)[1] < times[points.get(i)[0]]){
                    times[points.get(i)[0]] = cur_point[1] + points.get(i)[1];
                    que.add(new int[]{points.get(i)[0], cur_point[1] + points.get(i)[1]});
                }
            }
            
        }
    }
}