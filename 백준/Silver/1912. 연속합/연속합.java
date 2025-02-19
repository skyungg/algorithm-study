import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] dp = new int[n];		// i번째까지의 연속 합
		dp[0] = arr[0];
		int maxSum = arr[0];
		for(int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);		// 이전까지합+현재합, 현재값
			maxSum = Math.max(maxSum, dp[i]);
		}
		
		System.out.println(maxSum);

	}

}
