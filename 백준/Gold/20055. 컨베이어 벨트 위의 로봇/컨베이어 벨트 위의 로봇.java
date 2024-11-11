import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 벨트 길이의 절반
        int K = sc.nextInt(); // 내구도가 0인 칸의 임계값

        int[] durability = new int[2 * N]; // 벨트의 내구도 배열
        boolean[] robots = new boolean[2 * N]; // 로봇 위치 배열

        for (int i = 0; i < 2 * N; i++) {
            durability[i] = sc.nextInt();
        }

        int steps = 0;
        int zeroDurabilityCount = 0;
        int start = 0;  // 시작 위치
        int end = N - 1;  // 내리는 위치

        while (true) {
            steps++;

            // 1. 벨트를 회전
            start = (start - 1 + 2 * N) % (2 * N);
            end = (end - 1 + 2 * N) % (2 * N);

            // 로봇이 내리는 위치에 도달하면 내림
            if (robots[end]) {
                robots[end] = false;
            }

            // 2. 로봇 이동
            for (int i = end; i != start; i = (i - 1 + 2 * N) % (2 * N)) {
                int prev = (i - 1 + 2 * N) % (2 * N);
                if (robots[prev] && !robots[i] && durability[i] > 0) {
                    robots[prev] = false;
                    robots[i] = true;
                    durability[i]--;
                    if (durability[i] == 0) {
                        zeroDurabilityCount++;
                    }
                }
            }

            // 내리는 위치에 도달한 로봇은 내림
            if (robots[end]) {
                robots[end] = false;
            }

            // 3. 로봇 올리기
            if (!robots[start] && durability[start] > 0) {
                robots[start] = true;
                durability[start]--;
                if (durability[start] == 0) {
                    zeroDurabilityCount++;
                }
            }

            // 4. 종료 조건 확인
            if (zeroDurabilityCount >= K) {
                break;
            }
        }

        System.out.println(steps);
    }
}
