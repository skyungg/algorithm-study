import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int n = 0;
        int m = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int missile = 0;    // 요격미사일요격미사일
        for(int i =0; i < targets.length; i++){
            if(missile > targets[i][0]) continue;
            missile = targets[i][1];
            answer++;
        }
        
        
        return answer;
    }
}