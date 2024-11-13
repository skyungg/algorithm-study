class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int mod = n % 3;    // 3으로 나눈 나머지
            n = n/3;    // 3으로 나눴을 때 몫
            
            if(mod == 0){
                sb.append(4);  // 나머지가 0일 때는 4
                n--;    // 나누어 떨어졌을 때는 n을 1 감소
            }
            else{
                sb.append(mod);     // 그 이외 나머지는 1 or 2
            }
        }
        
        return sb.reverse().toString();
    }
}