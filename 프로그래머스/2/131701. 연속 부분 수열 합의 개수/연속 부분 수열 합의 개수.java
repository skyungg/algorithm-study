import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;
        int [] newElements = new int[n*2];
        
        for(int i = 0; i < n; i++){         // 길이가 두 배인 배열
            newElements[i] = elements[i];
            newElements[i+n] = elements[i];
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < i+n; j++){
                int num = 0;
                for(int k = i; k <= j; k++){
                    num += newElements[k];
                }
                set.add(num);
            }
        }
        
        answer = set.size();
        return answer;
    }
}