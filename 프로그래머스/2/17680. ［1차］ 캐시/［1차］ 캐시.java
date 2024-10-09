import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        if(cacheSize == 0) return cities.length * 5;    // 캐시 적용 모하면 도시배열 길이 *5
        
        for(int i = 0; i < cities.length; i++){
            String str = cities[i].toUpperCase();   // 대문자 변화
            
            if(list.contains(str)){
                list.remove(str);
                list.add(str);
                answer += 1;
            }else{
                if(list.size() >= cacheSize){
                    list.remove(0);
                }
                list.add(str);
                answer += 5;
            }  
        }
        
        
        return answer;
    }
}