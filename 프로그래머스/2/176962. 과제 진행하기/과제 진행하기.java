import java.util.*;

/*
아이디어: que, stack
1. plans에 있는 것들 class 정의해서 pq에 넣기
2. 시작 시각 기준으로 정렬하기
3. pq에서 꺼내고, 그 다음타자, stack 비교해서 하기
4. 둘 중 먼저 인거 처리
*/
class Solution {
    class Point implements Comparable<Point>{
        String name;
        int start;
        int time;
        
        public Point(String name, int start, int time){
            this.name = name;
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo(Point p){
            return this.start - p.start;
        }
    }
    
    public String[] solution(String[][] plans) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for(String [] plan : plans){
            pq.add(new Point(plan[0], toMin(plan[1]),  Integer.parseInt(plan[2])));
        }
        
        String [] answer = new String[plans.length];
        Stack<Point> stack = new Stack<>(); // 진행 중인 과제
        
        Point p = pq.poll();
        int curTime = p.start;
        int cnt = 0;
        
        // 실행하기
        while(true){
            if(!pq.isEmpty() && (curTime + p.time) > pq.peek().start){
                // 현재 진행중인 과제 끝나는 시각 > 다음에 진행할 새로운 과제 시작 시각
                stack.push(new Point(p.name, p.start, p.time-(pq.peek().start-curTime)));
                curTime = pq.peek().start;
                p = pq.poll();      // 새로운 과제 시작
            }
            else{
                answer[cnt++] = p.name;
                curTime += p.time;
                
                // 새로 시작 하는 과제
                if(!pq.isEmpty() && curTime == pq.peek().start){
                    p = pq.poll();
                }else if(!stack.isEmpty()){
                    // 멈춘 과제 다시 시작
                    p = stack.pop();
                }else if(!pq.isEmpty()){
                    p = pq.poll();
                    curTime = p.start;
                }else break;
            }
        }
        
        return answer;
    }
    
    int toMin(String time){
        // 시간 -> 분으로 전환
        String [] tmp = time.split(":");
        return Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]); 
    } 
}