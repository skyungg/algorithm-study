import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i <= t*m; i++){
            sb.append(Integer.toString(i, n));  
        }
        
        String [] arr = sb.toString().split("");
        StringBuilder result = new StringBuilder();
        int count = 0;
        
        for(int i = p-1; i < arr.length; i=i+m){
            if(count == t) break;
            
            String tmp = arr[i];
            char ch = tmp.charAt(0);
            if(Character.isAlphabetic(ch)){
                result.append(tmp.toUpperCase());  // i -> n진법으로 표현
            }else{
                result.append(tmp);  // i -> n진법으로 표현
            }
            count++;
        }
        
        return result.toString();
    }
}