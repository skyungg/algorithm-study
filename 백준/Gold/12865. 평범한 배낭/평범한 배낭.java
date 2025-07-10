import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[N+1][2];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// dp
		int [][] dp = new int[N+1][K+1];	// <i번째 아이템까지> 고려했을 때, <무게 j까지> 최대가치
		for(int i = 1; i <= N; i++) {
			for(int w = 1; w <= K; w++) {
				// i번째 아이템 선택 안하고 이전껄로만 최대 가치 구하기
				dp[i][w] = dp[i-1][w];
				
				// i번째 아이템 선택 (담을 수 있는 경우)
				if(arr[i][0] <= w) {
					dp[i][w] = Math.max(dp[i][w], dp[i-1][w-arr[i][0]]+arr[i][1]);
				}
			}
		}
		
		
		System.out.println(dp[N][K]);
	}


}
