import java.util.*;
/*
1. 조합 수대로 후보키 생성
2. 1의 유일성, 최소성 검사
*/

class Solution {
    String[][] relation;
    int row, column;
    List<HashSet<Integer>> keyList;
    
    public int solution(String[][] relation) {
        this.relation = relation;
        row = relation.length;  // 로우 길이
        column = relation[0].length;  // 컬럼 길이  
        keyList = new ArrayList<>();
        
        // 조합
        for(int i = 1; i <= column; i++){
            combination(i, 0, 0, new HashSet<>());
        }
        
        return keyList.size();
    }
    
    void combination(int depth, int idx, int cnt, HashSet<Integer> set){
        if(depth == cnt){
            // 1. 유일성 검사하기
            if(!isUnique(set)) return;
            
            // 2. 최소성 검사하기
            for(HashSet<Integer> key : keyList){
                if(set.containsAll(key)) return;
            }
            
            keyList.add(set);   // 현재 조합 추가하기
            return;

        }
        
        // 조합 생성
        for(int i = idx; i < column; i++){
            HashSet<Integer> newSet = new HashSet<>(set);   // 기존의 set을 이용해서 새로운 set 생성
            newSet.add(i);
            combination(depth, idx+1, cnt+1, newSet);
        }
    }
    
    boolean isUnique(HashSet<Integer> set){
        HashSet<String> tmpSet = new HashSet<>();
        
        for(int r = 0; r < row; r++){
            StringBuilder sb = new StringBuilder();
            for(int num : set){
                sb.append(relation[r][num]+",");
            }
            tmpSet.add(sb.toString());
        }
        
        return tmpSet.size() == row;
    }
}