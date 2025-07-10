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
			int [][] dp = new int[n][3];	// 0:아무것도 선택X, 1:첫번째 행, 2:두 번째 행 선택
			dp[0][0] = 0;
			dp[0][1] = board[0][0];
			dp[0][2] = board[1][0];
			
			for(int j = 1; j < n; j++) {
				dp[j][0] = Math.max(Math.max(dp[j-1][0], dp[j-1][1]), dp[j-1][2]);	// 아무것도 선택X
				dp[j][1] = Math.max(dp[j-1][0], dp[j-1][2]) + board[0][j];	// 첫 번째 행 선택
				dp[j][2] = Math.max(dp[j-1][0], dp[j-1][1]) + board[1][j];	// 두 번재 행 선택
			}
			
			sb.append(Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2])+"\n");
		}
		
		// 정답 출력
		System.out.println(sb.toString());
		

	}


}
