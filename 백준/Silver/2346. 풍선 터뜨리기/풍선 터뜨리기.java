import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<int[]> dq = new ArrayDeque<>(); 
        // {풍선 번호, 이동값}

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            dq.add(new int[]{i, move});
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();  // 현재 풍선
            int idx = cur[0];
            int move = cur[1];

            sb.append(idx).append(" ");

            if (dq.isEmpty()) break;

            if (move > 0) {
                // 오른쪽으로 move-1번 회전
                for (int i = 0; i < move - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                // 왼쪽으로 |move|번 회전
                for (int i = 0; i < -move; i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}