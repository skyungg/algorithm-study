import java.util.*;

class Solution {
    static String target;
    static String[] words;
    static int minCount = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        
        if(!Arrays.asList(words).contains(target)) return 0;
        
        int n = begin.length(); // 글자 크기
        
        // dfs 돌리기
        dfs(begin, new boolean[words.length], 0);      // 현재 단어, 현재 교환 횟수
        
        return minCount;
    }
    
    void dfs(String cur_word, boolean [] visited, int count){
        if(cur_word.equals(target)){
            minCount = Math.min(minCount, count);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(!visited[i] && checkWord(cur_word, words[i])){
                visited[i] = true;
                dfs(words[i], visited, count+1);
                visited[i] = false;
            }
        }
    }
    
    boolean checkWord(String cur_word, String word){
        int diff = 0;
        
        for(int i = 0; i < cur_word.length(); i++){
            if(cur_word.charAt(i) != word.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return true;
    }
}