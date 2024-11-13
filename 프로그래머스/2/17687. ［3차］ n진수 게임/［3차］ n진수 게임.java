import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; sb.length() <= t*m; i++){
            sb.append(Integer.toString(i, n));  
        }
        
        StringBuilder result = new StringBuilder();
        int count = 0;
        
        for(int i = p-1; result.length() < t; i=i+m){
            result.append(sb.charAt(i));
        }
        
        return result.toString().toUpperCase();
    }
}