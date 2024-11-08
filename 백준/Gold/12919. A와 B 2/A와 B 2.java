import java.io.*;

public class Main {
    static String s;
    static String t;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        dfs(t);
        System.out.println(answer);
    }

    static void dfs(String cur_str) {
        // 이미 답을 찾은 경우 더 이상 진행하지 않음
        if (answer == 1) return;

        // 현재 문자열이 s와 같다면 정답을 찾은 것으로 처리
        if (cur_str.equals(s)) {
            answer = 1;
            return;
        }

        // s보다 길이가 짧아지면 더 이상 변환이 불가능하므로 종료
        if (cur_str.length() <= s.length()) return;

        // 문자열이 'A'로 끝나는 경우, 마지막 'A'를 제거하고 재귀 호출
        if (cur_str.endsWith("A")) {
            dfs(cur_str.substring(0, cur_str.length() - 1));
        }

        // 문자열이 'B'로 시작하는 경우, 첫 글자 'B'를 제거하고 뒤집어서 재귀 호출
        if (cur_str.startsWith("B")) {
            StringBuilder sb = new StringBuilder(cur_str.substring(1));
            dfs(sb.reverse().toString());
        }
    }
}
