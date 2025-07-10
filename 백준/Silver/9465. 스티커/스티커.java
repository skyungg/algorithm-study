import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int [][] board = new int[2][n];
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// dp			
			int [][] dp = new int[2][n+1];	// 0:첫번째 행, 1:두 번째 행 선택
			dp[0][1] = board[0][0];
			dp[1][1] = board[1][0];
			
			for(int j = 2; j <= n; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + board[0][j-1];	// 첫 번째 행 선택
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + board[1][j-1];	// 두 번재 행 선택
			}
			
			sb.append(Math.max(dp[0][n], dp[1][n])+"\n");
		}
		
		// 정답 출력
		System.out.println(sb.toString());
		

	}


}
