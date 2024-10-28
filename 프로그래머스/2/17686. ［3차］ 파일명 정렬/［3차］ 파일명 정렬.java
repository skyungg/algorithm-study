import java.util.*;

class Solution {
    static class Point implements Comparable<Point> {
        String head;
        int number;
        int idx;
        
        public Point(String head, int number, int idx){
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Point o){
            if(this.head.equals(o.head)){
                if(this.number == o.number){
                    return this.idx - o.idx;
                }
                return this.number - o.number;
            }
            return this.head.compareTo(o.head);
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for(int i = 0; i < files.length; i++){
            String tmp[] = getInfo(files[i]);
            pq.offer(new Point(tmp[0], Integer.parseInt(tmp[1]), i));
        }
        
        int count = 0;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            answer[count++] = files[p.idx];
        }
        
        return answer;
    }
    
    String [] getInfo(String str){
        String [] tmp = new String[2];
        int start_idx = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isAlphabetic(ch)){
                sb.append(ch);
            }else if(Character.isDigit(ch)){
                start_idx = i;
                break;
            }else{
                sb.append(ch);
            }
        }
        tmp[0] = sb.toString().toLowerCase();
        sb.setLength(0);
        for(int i = start_idx; i < str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                sb.append(ch);
            }else{
                break;
            }
        }
        tmp[1] = sb.toString();
        
        return tmp;
    }
}