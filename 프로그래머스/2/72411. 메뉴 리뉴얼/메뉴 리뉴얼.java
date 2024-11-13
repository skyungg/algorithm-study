import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>(); // <문자조합, 빈도수>
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();   // 결과
        
        for(int cou : course){
            map = new HashMap<>(); // 매번 갱신
            
            // 크기가 cou인 조합 구하기
            for(String order : orders){
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr);
                combination(orderArr, cou, 0, "");
            }
            
            // 빈도수가 2이 이상인 조합에서 최빈값 구하기
            int maxCount = 0;
            for(int count : map.values()){
                maxCount = Math.max(maxCount, count);
            }
            
            // 최빈값인 조합 문자열 result에 추가하기
            if(maxCount < 2) continue;
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue() == maxCount){
                    result.add(entry.getKey());
                }
            }
        }
        
        String [] answer = new String[result.size()];
        Collections.sort(result);
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        
        return answer;
    }
    void combination(char [] order, int depth, int start, String str){
        if(depth == str.length()){
            map.put(str, map.getOrDefault(str, 0)+1);
            return;
        }
        
        for(int i = start; i < order.length; i++){
            combination(order, depth, i+1, str+order[i]);
        }
    }
}