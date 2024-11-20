import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> ary = new ArrayList<>();
        
        //총 경우의 수 n!
        long total = 1;
        for(int i=1;i<=n;i++)
        {
            ary.add(i);
            total *= i;
        }
        //배열의 인덱스는 0부터 시작하여 찾아야될 번호를 -1
        k--;
        
        int idx = 0;
        while(idx < n)
        {
            //전체 경우의 수 / 숫자의 갯수
            total /= n - idx;
            //해당 인덱스의 값의 숫자 가져오기
            answer[idx++] = ary.remove((int) (k/total));
            //다음 찾아야될 번호
            k %= total;
            
        }
        return answer;
    }
}