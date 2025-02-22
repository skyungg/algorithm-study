import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int [][] dp = new int[10001][3];
		dp[1][0] = dp[2][0] = dp[2][1] = dp[3][0] = dp[3][1] = dp[3][2] = 1;
		
		for(int i = 4; i < 10001; i++) {
			dp[i][0] = dp[i-1][0];
			dp[i][1] = dp[i-2][0] + dp[i-2][1];
			dp[i][2] = dp[i-3][0] + dp[i-3][1] + dp[i-3][2];
			
		}
		
		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int result = dp[n][0] + dp[n][1] + dp[n][2];
			sb.append(result+"\n");
		}
		
		System.out.println(sb.toString());

	}

}
