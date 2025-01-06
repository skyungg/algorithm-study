import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> caches = new LinkedList<>();   // 캐시 저장
        
        if(cacheSize == 0) return cities.length*5;
        
        for(String str : cities){
            String city = str.toUpperCase();    // 1. 모두 대문자 처리
            
            if(!caches.contains(city)){     // 2. cache에 없는 경우
                if(caches.size() >= cacheSize){
                    caches.remove(0);   // 캐시 교체 시 맨 앞 삭제
                }
                caches.add(city);
                answer += 5;
                
            }else{
                caches.remove(city);
                caches.add(city);
                answer += 1;
            }
        }
        
        
        return answer;
    }
}