import java.util.*;
/*
아이디어: 아마도 수학..?
w: 열, h: 행
*/
class Solution {
    public long solution(int w, int h) {
        long wLength = (long)w;   // 형 변환
        long hLength = (long)h;
        
        long gcd = getGcd(wLength, hLength);    // 최대 공약수
        
        long answer = (wLength*hLength) - ((wLength+hLength)-gcd);
        
        return answer;
    }
    
    long getGcd(long w, long h){
        if(h == 0) return w;
        
        return getGcd(h, (w%h));
    }
}