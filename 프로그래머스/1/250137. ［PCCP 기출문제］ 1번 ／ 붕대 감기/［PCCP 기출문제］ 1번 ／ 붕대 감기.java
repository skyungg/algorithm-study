import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curTime = 0;   // 현재 시간
        int curHealth = health;     // 현재 체력
        int cnt = 0;    // 연속 성공
        int attackIdx = 0;  // 공격
        int sCnt = 0;   // 연속 횟수
        
        // for문은 마지막 공격 시간까지 
        for(int i = 0; i <= attacks[attacks.length-1][0]; i++){
            // 공격 시간 돌아옴
            if(attackIdx < attacks.length && attacks[attackIdx][0] == i){
                curHealth -= attacks[attackIdx][1]; // 공격 차감
                sCnt = 0;   // 연속 횟수 초기화
                if(curHealth <= 0) return -1;
                attackIdx++;
            }else{
                sCnt++;
                curHealth += bandage[1];    // 초당회복량
                if(sCnt == bandage[0]){
                    curHealth += bandage[2];
                    sCnt = 0;
                }

                if(curHealth >= health) curHealth = health;
            }
        }
        
        return curHealth;
    }
}