import java.util.*;

/* 아이디어: 구현
1. 모든 시간을 초로 바꿔서 계산하기
*/
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int vTime = changeSecond(video_len);
        int curTime = changeSecond(pos);
        int openStartAt = changeSecond(op_start);
        int openEndAt = changeSecond(op_end);
        
        
        for(String cmd : commands){
            if(curTime >= openStartAt && curTime <= openEndAt) {
                curTime = openEndAt;
            }
            
            if(cmd.equals("next")){     // 10초 후 이동, 남은 시간 10초미만 -> 마지막 위치
                curTime += 10;
                if(curTime > vTime) curTime = vTime;
            }else if(cmd.equals("prev")){              // 10초 전으로 이동
                curTime -= 10;
                if(curTime < 0) curTime = 0;
            } 
            if(curTime >= openStartAt && curTime <= openEndAt) {
                curTime = openEndAt;
            }
        }
        
        // 정답 반환 -> mm:ss 형식으로 만들기
        int mm = curTime/60;    // 몫 -> 분
        int ss = curTime%60;    // 나머지 -> 초
        
        StringBuilder sb = new StringBuilder();
        if(mm < 10) sb.append("0"+mm+":");
        else sb.append(mm+":");
        
        if(ss < 10) sb.append("0"+ss);
        else sb.append(ss);
        
        return sb.toString();
    }
    
    // 시간 -> 초로 바꾸기
    int changeSecond(String time){
        String [] tmp = time.split(":");
        return Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
    }
}