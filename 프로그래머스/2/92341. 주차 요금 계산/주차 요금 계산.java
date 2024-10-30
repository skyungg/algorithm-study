import java.util.*;

class Solution {
    static int[] fees;
    static HashMap<String, ArrayList<String>> map = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;
        
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
        HashMap<String, Integer> hmap = parkingFee();
        int [] answer = new int[hmap.size()];
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        int count = 0;
        
        for (String key : keySet) {
            answer[count++] = hmap.get(key);
        }
        return answer;
    }
    
    HashMap<String, Integer> parkingFee(){
        HashMap<String, Integer> hmap = new HashMap<>();
        
        int count = 0;
        for(String key : map.keySet()){
            ArrayList<String> tmp = map.get(key);
            if(tmp.size()%2 != 0) map.get(key).add("23:59");
            
            int time = 0;
            for(int i = 0; i < tmp.size(); i+=2){
                String in = tmp.get(i);
                String out = tmp.get(i+1);
                time += calculateTime(in, out);
            }
            
            int fee = 0;
            if(time <= fees[0]) hmap.put(key, fees[1]);
            else{
                fee += fees[1];        // 기본 요금
                
                time -= fees[0];    // 기본 시간 제외
                if((time)%fees[2] != 0){
                    fee += ((time/fees[2])+1)*fees[3];
                }else{
                    fee += (time/fees[2])*fees[3];
                }
                hmap.put(key, fee);
            }
            count++;
        }
        return hmap;
    }
    
    int calculateTime(String in, String out){
        int in_hour = Integer.parseInt(in.substring(0, 2));
        int in_min = Integer.parseInt(in.substring(3, 5));
        int out_hour = Integer.parseInt(out.substring(0, 2));
        int out_min = Integer.parseInt(out.substring(3, 5));
        
        // 시간 계산
        int hour = 0;
        int min = 0;
        if(in_min == 0){
            if(in_hour == out_min){
                min = out_min;
            }else{
                hour = (out_hour-in_hour)*60;
                min = out_min;
            }
        }else{
            if(out_hour == in_hour){
                min = out_min-in_min;
            }else{
                hour = (out_hour-(in_hour+1))*60;
                min = out_min+(60-in_min);
            }
        }
        
        return hour+min;
    }
}