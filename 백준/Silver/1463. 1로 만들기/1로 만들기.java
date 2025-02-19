import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[n] = 0;
		
		
		for(int i = n; i > 0; i--) {
			if(i%3 == 0) {		// 3으로 나누어 떨어지는 경우
				int tmp = i/3;
				dp[tmp] = Math.min(dp[tmp], dp[i]+1);
			}
			if(i%2 == 0) {		// 2으로 나누어 떨어지는 경우
				int tmp = i/2;
				dp[tmp] = Math.min(dp[tmp], dp[i]+1);
			}
			if(dp[i-1] > dp[i]+1) {		// -1 감소
				dp[i-1] = dp[i]+1;
			}
		}
		
		System.out.println(dp[1]);
	}

}
