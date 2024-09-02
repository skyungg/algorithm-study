import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());		// 집의 개수
		
		int [][] arr = new int[N+1][3];		// r,g,b
		int [][] dp = new int[N+1][3];		// r,g,b
		
		StringTokenizer st = null;
		for(int i = 1; i <= N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			
		}
		
		// 0번째 각 배열의 값들 모두 0으로 초기화
		arr[0][0] = arr[0][1] = arr[0][2] = dp[0][0] = dp[0][1] = dp[0][2] = 0;
		
		// 점화식 이용한 풀이
		// R : 현재 비용 + 이전의 G와 B의 값 중 최소
		// G : 현재 비용 + 이전의 R와 B의 값 중 최소
		// B : 현재 비용 + 이전의 R와 G의 값 중 최소
		for(int i = 1; i <= N; i++) {
			dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);		// 현재 R의 최솟값 셋팅
			dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);		// 현재 G의 최솟값 셋팅
			dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);		// 현재 B의 최솟값 셋팅
		}
		
		// 결과 출력
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));

	}

}
