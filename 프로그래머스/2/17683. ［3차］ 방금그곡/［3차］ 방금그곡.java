import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";   // 기본값 none
        
        // 0. #처리
        m = convert(m);
        
        int resTime = 0;
        // 1. 정보 분리        
        for(int i = 0; i < musicinfos.length; i++){
            String [] tmp = musicinfos[i].split(",");
            int time = getTime(tmp[0], tmp[1]);
            String original = convert(tmp[3]);
            
            String melody = getMelody(time, original);

            if(containsMelody(melody, m)){
                if(time > resTime){
                    resTime = time;
                    answer = tmp[2];
                }
            }
        }
        return answer;
    }
    String convert(String str){
        return str.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a")
            .replaceAll("B#", "b");
    }
    
    int getTime(String start, String end){
        String [] sarr = start.split(":");
        String [] earr = end.split(":");
        
        int h = Integer.parseInt(earr[0]) - Integer.parseInt(sarr[0]);
        int m = Integer.parseInt(earr[1]) - Integer.parseInt(sarr[1]);
        
        return h*60+m;
    }
    
    String getMelody(int size, String str){
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        
        for(int i = 0; i < size; i++){
            sb.append(str.charAt(i%len));
        }
        
        
        return sb.toString(); 
    }
    
    boolean containsMelody(String melody, String m) {
        for (int i = 0; i <= melody.length() - m.length(); i++) {
            if (melody.startsWith(m, i)) {
                if (i + m.length() >= melody.length() || melody.charAt(i + m.length()) != '#') {
                    return true;
                }
            }
        }
        return false;
    }
}