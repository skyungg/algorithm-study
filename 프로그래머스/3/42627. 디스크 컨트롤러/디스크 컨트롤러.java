import java.util.*;

class Solution {
    static int [][] jobs;
    static class Point implements Comparable <Point>{
        int time;
        int start;
        
        public Point(int time, int start){
            this.time = time;
            this.start = start;
        }
        
        @Override
        public int compareTo(Point p){
            if(this.time == p.time) return this.start - p.start;
            
            return this.time - p.time;
        }
    }
    
    public int solution(int[][] jobs) {
        this.jobs = jobs;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int answer = bfs();
        return answer;
    }
    
    int bfs(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int totalTime = 0;
        int currentTime = 0;    // 현재 시간
        int index = 0;          // jobs 배열의 인덱스
        int n = jobs.length;
        
        while(index < n || !pq.isEmpty()){
            
            while(index < n && jobs[index][0] <= currentTime){
                pq.add(new Point(jobs[index][1], jobs[index][0]));
                index++;
            }
            
            if(pq.isEmpty()){
                currentTime = jobs[index][0];
            }else{
                Point p = pq.poll();
                currentTime += p.time;
                totalTime += currentTime - p.start;
            }
        }
        
        return totalTime/n;
    }
    
    
}