import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int [][] dp = new int[41][2];
			
			dp[0][0] = dp[1][1] = dp[2][0] = dp[2][1] = 1;
			dp[0][1] = dp[1][0] = 0;
			
			for(int i = 3; i <= n; i++) {
				dp[i][0] = dp[i-1][0] + dp[i-2][0];
				dp[i][1] = dp[i-1][1] + dp[i-2][1];
			}
			
			sb.append(dp[n][0]+" "+dp[n][1]+"\n");
		}
		
		System.out.println(sb.toString());

	}

}
