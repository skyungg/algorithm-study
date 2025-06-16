import java.util.*;

/*
아이디어: 완탐
*/
class Solution {
    List<Long> nums = new ArrayList<>();
    List<Character> opList = new ArrayList<>();
    Set<Character> set = new HashSet<>();
    ArrayList<Character> list;
    long maxCost = 0;
    
    public long solution(String expression) {
        // 분리하기
        seperate(expression);
        list = new ArrayList<>(set);    // set을 list로 변환
        
        // 연산자 순열 생성
        permutation(new int[set.size()], 0, new boolean[set.size()], new char[set.size()]);
        
        return maxCost;
    }
    
    long getCost(char [] output){
        List<Long> curNums = new ArrayList<>(nums);  // 깊은 복사
        List<Character> curOp = new ArrayList<>(opList);
        long result = 0;
        
        for(char op : output){
            
            int i = 0;
            while(i < curOp.size()){
                if(curOp.get(i) == op){
                    long pre = curNums.get(i);    // 연산자 앞 숫자
                    long next = curNums.get(i+1);   // 연산자 뒷 숫자
                    long curResult = 0;             // 현재 연산 결과
                    
                    if(op == '*') curResult = pre * next;
                    else if(op == '+') curResult = pre + next;
                    else if(op == '-') curResult = pre - next;
                    
                    curNums.remove(i);      // a제거
                    curNums.remove(i);      // b제거
                    curNums.add(i, curResult);
                    
                    curOp.remove(i);       // 현재 연산자 제거
                } else i++;
            }
            
            
        }
        
        return Math.abs(curNums.get(0));
    }
    
    void permutation(int [] arr, int cnt, boolean [] visited, char [] output){
        if(cnt == arr.length){
            // 조합 생성 완료
            maxCost = Math.max(maxCost, getCost(output));
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                output[cnt] = list.get(i);
                visited[i] = true;
                permutation(arr, cnt+1, visited, output);
                visited[i] = false;
            }
        }
    }
    
    void seperate(String expression){
        String tmp = "";
        
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '*' || expression.charAt(i) == '+' 
               || expression.charAt(i) == '-'){
                set.add(expression.charAt(i));
                opList.add(expression.charAt(i));           // 연산자 추가
                nums.add(Long.parseLong(tmp));  // 숫자 추가
                tmp = "";
            }else tmp += expression.charAt(i);
        }
        
        // 마지막 숫자 추가
        nums.add(Long.parseLong(tmp));
        
        return;
    }
}