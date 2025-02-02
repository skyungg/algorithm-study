import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N - 1]; // 거리
        long[] cost = new long[N];     // 비용 

        String[] distInput = br.readLine().split(" ");
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(distInput[i]);
        }

        String[] costInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(costInput[i]);
        }

        long sum = 0;
        long minCost = cost[0];

        for (int i = 0; i < N - 1; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += minCost * dist[i];
        }

        System.out.println(sum);
    }
}
