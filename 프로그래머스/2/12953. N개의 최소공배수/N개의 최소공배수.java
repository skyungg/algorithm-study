import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int answer = arr[0];    // 첫 번째 요소
        for(int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);   // 두 수의 최소 공배수 구하기
        }
        
        return answer;
    }
    
    int lcm(int a, int b){      // 최소 공배수
        return (a*b)/gcd(a, b);
    }
    
    int gcd(int a, int b){     // 최대 공약수
        if(b==0) return a;
        
        return gcd(b, a%b);
    }
}