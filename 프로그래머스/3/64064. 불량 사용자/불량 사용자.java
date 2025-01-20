import java.util.*;

class Solution {
    
    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> set = new HashSet<>();
        
        // 백트래킹
        backtrack(user_id, banned_id, 0, new HashSet<>(), set);
        
        return set.size();
    }
    
    void backtrack(String[] user_id, String[] banned_id, int idx, Set<String> curSet, Set<Set<String>> set){
        if(idx == banned_id.length){
            set.add(new HashSet(curSet));   // 현재 조합 추가
            return;
        }
        
        String bId = banned_id[idx];
        for(String user: user_id){
            if(!curSet.contains(user) && isMatch(user, bId)){
                curSet.add(user); // 유저의 아이디를 현재 조합에 추가
                backtrack(user_id, banned_id, idx+1, curSet, set);
                curSet.remove(user);
            }
        }
    }
    
    boolean isMatch(String user, String b_id){
        if(user.length() != b_id.length()) return false;    // 길이 다르면 비교 불가
        
        // 문자별로 비교
        for(int i = 0; i < user.length(); i++){
            if(b_id.charAt(i) != '*' && user.charAt(i) != b_id.charAt(i)) return false;
        }
        
        return true;
    }
}