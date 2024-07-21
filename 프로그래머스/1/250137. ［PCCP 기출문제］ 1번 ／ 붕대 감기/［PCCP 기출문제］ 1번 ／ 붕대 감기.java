class Solution {
    int curHealth;
    int curTime;
    int count;
    int maxHealth;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        curHealth = health;     // 현재 체력
        curTime = 1;            // 현재 시간
        count = 0;              // 연속 성공 수
        maxHealth = health;     // 최대 체력
        
        
        for(int i = 0; i < attacks.length; i++){
            int attack_time = attacks[i][0];    // 공격 시간
            attack(bandage, attack_time);
            curHealth -= attacks[i][1];     // 피해
            if(curHealth <= 0){
                break;
                // return -1;
            }
            count = 0;          // 연속 성공 수 초기화  
            curTime++;
        }
        
        if(curHealth > 0){
            return curHealth;
        }else{
            return -1;
        }
    }
    
    void attack(int[] bandage, int attack_time){
        for(int i = curTime; i < attack_time; i++){
            count++;    // 연속 성공 증가
            curTime++;  // 시간 증가
            
            if(curHealth + bandage[1] >= maxHealth){
                curHealth = maxHealth;
            }else{
                curHealth += bandage[1];       // 회복량
            }

            
            if(count == bandage[0]){
                // 연속 성공했을 경우
                if(curHealth+bandage[2] >= maxHealth){
                    curHealth = maxHealth;
                }else{
                    curHealth += bandage[2];    // 추가 회복량
                }
                count = 0;  // 연속 성공 초기화           
            }
            
        }
    }
}