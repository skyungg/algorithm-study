import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        s = s.replace("},{", "-");
        String [] tmp = s.split("-");
        Arrays.sort(tmp, (a, b) -> (a.length()-b.length()));    // 나눠진 문자열 길이별로 정렬
        ArrayList<Integer> list = new ArrayList<>();
        for(String str : tmp){
            String [] temp = str.split(",");
            for(int i = 0; i < temp.length; i++){
                int num = Integer.parseInt(temp[i]);
                if(!list.contains(num)) list.add(num);
            }
        }

        int answer [] = new int[list.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}