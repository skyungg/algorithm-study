import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        Queue<String []> que = new LinkedList<>();
        
        for(int i = 0; i < record.length; i++){
            String [] tmp = record[i].split(" ");
            
            if(tmp[0].equals("Enter")){
                que.add(new String[] {"님이 들어왔습니다.", tmp[1]});
                if(!map.containsKey(tmp[1])){
                    map.put(tmp[1], tmp[2]);
                }else{
                    if(!map.get(tmp[1]).equals(tmp[2])){
                        map.replace(tmp[1], tmp[2]);
                    }
                }
            }else if (tmp[0].equals("Leave")){
                que.add(new String[] {"님이 나갔습니다.", tmp[1]});
            }else{
                if(!map.get(tmp[1]).equals(tmp[2])){
                    map.replace(tmp[1], tmp[2]);
                }
            }
        }
        
        String[] answer = new String[que.size()];
        int count = 0;
        while(!que.isEmpty()){
            String [] tmp = que.poll();
            
            answer[count++] = map.get(tmp[1])+tmp[0];
        }
                      
                      
        return answer;
    }
}