class Solution {    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            int mod = n%3;  // 3으로 나눈 나머지
            n = n/3;    // 3으로 나눈 몫
            
            if(mod == 0){
                // 3의 배수 -> 끝자리 4
                sb.append(4);
                n--;
            }else{
                sb.append(mod);
            }
        }
        
        return sb.reverse().toString();
    }
}