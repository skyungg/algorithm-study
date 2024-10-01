import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < want.length; j++) {
                if (discount[i].equals(want[j])) number[j]--;
            }
        }

        if (isCheck(number)) answer++;      // 1일차부터 10차까지의 결과

        // 10일 이후부터 판단
        for (int i = 10; i < discount.length; i++) {
            
            for (int j = 0; j < want.length; j++) {
                if (discount[i - 10].equals(want[j])) number[j]++;    // 시작날 이전값이라면 증가
                if (discount[i].equals(want[j])) number[j]--;       // 시작날 값과 같으면 감소
            }
            if (isCheck(number)) answer++;
        }

        return answer;
    }

    static boolean isCheck(int[] number){
        boolean flag = true;
        for(int i = 0; i < number.length; i++){
            if(number[i] != 0) flag = false;
        }

        return flag;
    }

}