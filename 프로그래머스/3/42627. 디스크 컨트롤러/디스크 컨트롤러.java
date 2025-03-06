import java.util.*;

class Solution {
    class Point implements Comparable<Point> {
        int startAt;
        int time;
        
        public Point(int startAt, int time){
            this.startAt = startAt;
            this.time = time;
        }
        
        @Override
        public int compareTo(Point p){
            // 우선순위 소요시간 -> 요청 시각
            if(this.time == p.time) return this.startAt - p.startAt;
            return this.time - p.time;
        }
        
        
    }
    public int solution(int[][] jobs) {
        // 1. 요청시각 기준 오름차순 정렬
        Arrays.sort(jobs, (a, b) -> a[0]-b[0]);
        
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        int n = jobs.length;
        int idx = 0;      // 진행하고 있는 순서
        int endAt = 0;    // 현재 시각
        int count = 0;    // 완료된 작업 수
        int total = 0;    // 총 소요시간 
        
        while(count < n){
            while(idx < n && jobs[idx][0] <= endAt){
                pq.add(new Point(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()){
                endAt = jobs[idx][0];
            }else{
                Point p = pq.poll();
                endAt += p.time;    // 작업 끝나는 시간 갱신
                total += (endAt - p.startAt);       //요청 시각 ~ 작업 끝나는 시각
                count++;
            }
        }
        
        return total/n;
    }
}