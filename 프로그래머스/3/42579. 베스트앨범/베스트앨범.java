import java.util.*;

class Solution {
    class Point{
        int play;
        int idx;
        
        public Point(int play, int idx){
            this.play = play;
            this.idx = idx;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hmap = new HashMap<>();
        HashMap<String, List<Point>> map = new HashMap<>();
        
        // 1. 장르 
        for(int i = 0; i < genres.length; i++){
            if(!hmap.containsKey(genres[i])){
                hmap.put(genres[i], plays[i]);
            }else{
                hmap.put(genres[i], hmap.get(genres[i])+plays[i]);
            }
            //hmap.putIfAbsent(genres[i], plays[i]);
            
            if(!map.containsKey(genres[i])){
                map.put(genres[i], new ArrayList<>());
            }
            map.get(genres[i]).add(new Point(plays[i], i));
        }
        
        // 2. hmap 정렬
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hmap.entrySet());
        list.sort((a, b) -> (hmap.get(b.getKey()) - hmap.get(a.getKey())));
        
        // 3. map 정렬
        for(String key : map.keySet()){
            List<Point> tmpList = map.get(key);
            Collections.sort(tmpList, (a, b) -> {
                if(a.play == b.play) return a.idx - b.idx;
                else return b.play - a.play;
            });
        }
        
        // 4. 정답 출력
        List<Integer> answerList = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry : list){
            String key = entry.getKey();
            
            if(map.get(key).size() < 2){
                answerList.add(map.get(key).get(0).idx);
            }else{
                int limit = 0;
                for(Point p : map.get(key)){
                    if(limit >= 2) break;
                    answerList.add(p.idx);
                    limit++;
                }
            }
        }
        
        int[] answer = new int[answerList.size()]; 
        int cnt = 0;
        for(int index : answerList){
            answer[cnt++] = index;
        }
        return answer;
    }
}