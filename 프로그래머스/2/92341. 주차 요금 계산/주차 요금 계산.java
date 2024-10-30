import java.util.*;

class Solution {
    static int[] fees;
    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        // 1. map -> 차량번호마다 입출차 시간 저장
        for(int i = 0; i < records.length; i++){
            String [] tmp = records[i].split(" ");
            if(!map.containsKey(tmp[1])){
                ArrayList<String> list = new ArrayList<>();
                list.add(tmp[0]);
                map.put(tmp[1], list);
            }else{
                map.get(tmp[1]).add(tmp[0]);
            }
        }
        
        // 2. 주차 요금 계산하기
        HashMap<String, Integer> hmap = parkingFee(map);
        int [] answer = new int[hmap.size()];
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        int count = 0;
        
        for (String key : keySet) {
            answer[count++] = hmap.get(key);
        }
        return answer;
    }
    
    HashMap<String, Integer> parkingFee(HashMap<String, ArrayList<String>> map){
        HashMap<String, Integer> hmap = new HashMap<>();
        
        for(String key : map.keySet()){
            ArrayList<String> tmp = map.get(key);
            if(tmp.size()%2 != 0) map.get(key).add("23:59");
            
            int time = 0;
            for(int i = 0; i < tmp.size(); i+=2){
                time += calculateTime(tmp.get(i), tmp.get(i+1));
            }
            
            int fee = calculateFee(time);
            hmap.put(key, fee);
        }
        return hmap;
    }
    
    int calculateTime(String in, String out){
        int in_hour = Integer.parseInt(in.substring(0, 2));
        int in_min = Integer.parseInt(in.substring(3, 5));
        int out_hour = Integer.parseInt(out.substring(0, 2));
        int out_min = Integer.parseInt(out.substring(3, 5));

        return (out_hour*60+out_min)-(in_hour*60+in_min);
    }
    
    int calculateFee(int time){
        if(time <= fees[0]) return fees[1];     // 기본 시간 이내
        
        int extraTime = time - fees[0];
        int extraFee = (int) Math.ceil((double)extraTime/fees[2])*fees[3];
        
        return fees[1] + extraFee;        
    }
}