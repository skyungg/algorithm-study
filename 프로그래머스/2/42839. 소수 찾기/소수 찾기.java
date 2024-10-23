import java.util.*;

class Solution {
    static Set<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        String [] str = numbers.split("");
        int n = str.length;
        set = new HashSet<>();
        
        
        for(int i = 1; i <= n; i++){
            permutation(str, "", new boolean[n], i);
        }
        
        for(int num : set){
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    void permutation(String [] arr, String str, boolean [] visited, int r){
        if(str.length() == r){
            set.add(Integer.parseInt(str));
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(arr, str+arr[i], visited, r);
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}