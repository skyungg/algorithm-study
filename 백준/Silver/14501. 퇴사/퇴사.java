import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] arr = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());        // 상담 걸리는 기간
            arr[i][1] = Integer.parseInt(st.nextToken());        // 받을 수 있는 금액
        }

        int [] dp = new int[n+1];
        for(int i = 0; i < n; i++){
            if(i+arr[i][0] <= n){       // 날짜가 초과되지 않았을 경우
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
            }
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }

        System.out.println(dp[n]);
    }
}
