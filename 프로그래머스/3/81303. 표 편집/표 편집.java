import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        TreeSet<Integer> rows = new TreeSet<>(); //
        Stack<Integer> stack = new Stack<>(); // 최근 삭제
        
        // 초기화
        for (int i = 0; i < n; i++) {
            rows.add(i);
        }
        
        // 구현
        for (String str : cmd) {
            if (str.equals("C")) { // 삭제
                stack.push(k); // 삭제된 행 기록
                rows.remove(k); // 현재 행 삭제
                
                // 커서 이동
                if (rows.higher(k) != null) {
                    k = rows.higher(k);
                } else {
                    k = rows.lower(k);
                }
            } else if (str.equals("Z")) { // 복구
                rows.add(stack.pop());
                
            } else { // 이동 명령 처리
                char op = str.charAt(0);
                int cnt = Integer.parseInt(str.substring(2));
                
                if (op == 'D') { // 아래로 이동
                    while (cnt-- > 0) {
                        k = rows.higher(k);
                    }
                } else if (op == 'U') { // 위로 이동
                    while (cnt-- > 0) {
                        k = rows.lower(k);
                    }
                }
            }
        }
        
        // 판단
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(rows.contains(i)) sb.append("O");
            else sb.append("X");
        }
        
        String answer = sb.toString();
        return answer;
    }  

}