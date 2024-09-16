import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static String str;
    public static int solution(String word) {
        int answer = 0;
        str = "AEIOU";
        dfs("");
        return list.indexOf(word);
    }

    public static void dfs(String s){
        if(s.length() > 5) return;      // 다너 길이가 5보다 크면 종료

        list.add(s);

        for(int i = 0; i < 5; i++){
            dfs(s + str.charAt(i));
        }
    }
}