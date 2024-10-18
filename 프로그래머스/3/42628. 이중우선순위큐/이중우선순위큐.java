import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        int count = 0;  // 원소
        
        for(String str : operations){
            String [] tmp = str.split(" ");
            String op = tmp[0]; // 명령어 글자
            int num = Integer.parseInt(tmp[1]);
            
            if(op.equals("I")){ // 삽입하기
                maxPq.add(num);
                minPq.add(num);
                
                count++;    // 삽입할 때 증가
                
            }else if(op.equals("D")){
                if(count == 0) continue;    // 큐가 비었을 때
                
                if(num == 1){       // 최댓값 삭제
                    int n = maxPq.poll();
                    minPq.remove(n);
                }else{              // 최솟값 삭제
                    int n = minPq.poll();
                    maxPq.remove(n);
                }
                count--;
            }
        }
        
        if(count == 0) return new int[] {0, 0};      // 큐가 비었을 때
        
        return new int[] {maxPq.peek(), minPq.peek()};
    }
}