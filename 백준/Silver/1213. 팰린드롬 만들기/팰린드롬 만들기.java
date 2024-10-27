import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();       // 전체 길이

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        // 홀수인 알파벳 체크
        int oddCount = 0;
        char oddChar = 0;
        for(char key : map.keySet()){
            if(map.get(key) % 2 != 0){
                oddCount++;
                oddChar = key;
            }
        }

        // 팰린드롬 불가능 -> 2개 이상 홀수인 알파벳 존재
        if(oddCount > 1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        StringBuilder half_word = new StringBuilder();

        for(char key : keys){
            int count = map.get(key) / 2;       // 절반만 붙이기
            for(int i = 0; i < count; i++){
                half_word.append(key);
            }
        }

        StringBuilder full_word = new StringBuilder(half_word);
        if(oddCount == 1) full_word.append(oddChar);

        full_word.append(half_word.reverse());
        System.out.println(full_word.toString());
    }
}
