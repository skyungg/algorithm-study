class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcd_a = arrayA[0];
        for(int i = 1; i < arrayA.length; i++){
            gcd_a = gcd(gcd_a, arrayA[i]);
        }
        
        boolean flagA = true;
        for(int i = 0; i < arrayB.length; i++){
            if(arrayB[i] >= gcd_a && arrayB[i]%gcd_a ==0){
                flagA = false;
                break;
            }
        }
        
        int gcd_b = arrayB[0];
        for(int i = 1; i < arrayB.length; i++){
            gcd_b = gcd(gcd_b, arrayB[i]);
        }
        
        boolean flagB = true;
        for(int i = 0; i < arrayA.length; i++){
            if(arrayA[i] >= gcd_b && arrayA[i]%gcd_b ==0){
                flagB = false;
                break;
            }
        }
        
        if(flagA && flagB){
            answer = Math.max(gcd_a, gcd_b);
        }else{
            if(flagA) answer = gcd_a;
            else if(flagB) answer = gcd_b;
            else answer = 0;
        }
        
        
        
        return answer;
    }
    
    int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}