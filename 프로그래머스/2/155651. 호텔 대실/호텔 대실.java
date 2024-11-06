import java.util.*;

class Solution {
    
    public int solution(String[][] book_time) {
        ArrayList<int []> list = new ArrayList<>();
        
        // 입실 시간 기준으로 정렬
        Arrays.sort(book_time, (a, b) -> {
            int startA = Integer.parseInt(a[0].substring(0, 2)) * 60 + Integer.parseInt(a[0].substring(3));
            int startB = Integer.parseInt(b[0].substring(0, 2)) * 60 + Integer.parseInt(b[0].substring(3));
            return Integer.compare(startA, startB);
        });
        
        
        for(String [] time : book_time){
            int startHour = Integer.parseInt(time[0].substring(0, 2));
            int startMin = Integer.parseInt(time[0].substring(3));
            int start = startHour * 60 + startMin;

            int endHour = Integer.parseInt(time[1].substring(0, 2));
            int endMin = Integer.parseInt(time[1].substring(3));
            int end = endHour * 60 + endMin + 10;  // 퇴실 후 10분을 추가
            
            boolean flag = false;   // 수용 가능 여부
            
            for(int i = 0; i < list.size(); i++){
                int[] room = list.get(i);
                
                if (room[1] <= start) {
                    room[0] = start;
                    room[1] = end;
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                list.add(new int[] {start, end});
            }
        }

        return list.size();
    }

}