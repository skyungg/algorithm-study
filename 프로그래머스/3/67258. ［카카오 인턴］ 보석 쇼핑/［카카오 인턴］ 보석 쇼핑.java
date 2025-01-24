/*
아이디어 : 투포인터?
- set만큼으로 진행후, 없으면 gems-1까지 하나씩 늘리기
-> 시간초과 발생할듯

*/
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        for(String str : gems){
            set.add(str);
        }
        int n = set.size();     // 보석 종류
        
        int start = 0;
        int end = 0;
        int[] answer = {0, Integer.MAX_VALUE};
        HashMap<String, Integer> hmap = new HashMap<>();
        
        while(end < gems.length){
            // 1. end 확장하면서 보석 추가하기
            hmap.put(gems[end], hmap.getOrDefault(gems[end], 0)+1);
            end++;
            
            // 2. 조건 판별하기
            while(hmap.size() == n){
                if(end-start-1 < answer[1]-answer[0]){
                    answer[0] = start;
                    answer[1] = end-1;  // 위에서 더해짐
                }
                
                // start 위치 보석 제거
                if(hmap.get(gems[start]) == 1){
                    hmap.remove(gems[start]);
                }else{
                    hmap.put(gems[start], hmap.get(gems[start])-1);
                }
                start++;
            }
        }
        answer[0] += 1;
        answer[1] += 1;
        return answer;
    }
}