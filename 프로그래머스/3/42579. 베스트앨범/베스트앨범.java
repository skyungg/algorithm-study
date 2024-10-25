import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hmap = new HashMap<>();
        HashMap<String, ArrayList<int[]>> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            hmap.put(genres[i], hmap.getOrDefault(genres[i], 0)+plays[i]);
            
            if(map.containsKey(genres[i])){
                map.get(genres[i]).add(new int[]{plays[i], i});
            }else{
                ArrayList<int[]> list = new ArrayList<>();
                list.add(new int[]{plays[i], i});
                map.put(genres[i], list);
            }
        }
        
         List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hmap.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());  // 내림차순 정렬
        
        ArrayList<Integer> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
            String genre = entry.getKey();
            ArrayList<int[]> list = map.get(genre);
            
             list.sort((a, b) -> {
                if (b[0] == a[0]) {
                    return a[1] - b[1];  // 재생 횟수가 같으면 고유 번호가 낮은 순
                }
                return b[0] - a[0];  // 재생 횟수가 많은 순
            });
            
            for (int i = 0; i < Math.min(2, list.size()); i++) {
                result.add(list.get(i)[1]);
            }
        }
        
        int [] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}