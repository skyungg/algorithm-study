import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;   // 현재 아파트 동 위치
        int idx = 0;        // stations에서의 index
        
        while(position <= n){
            if(idx < stations.length && position >= stations[idx]-w){     // 1. 기지국 설치 X
                position = stations[idx]+w+1;   // 현재 위치의 기지국 영향권+1로 갱신
                idx++;
            }else{
                // 2. 기존의 기지국 영향권 밖 -> 설치 필요
                answer++;
                position += (w*2)+1;
            }
        }
        
        return answer;
    }
}