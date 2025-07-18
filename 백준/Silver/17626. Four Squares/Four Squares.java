import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int [] dp = new int[n+1];	// 숫자 i를 제곱수로 만들 때 드는 최소 개수
		
		for(int i = 1; i <= n; i++) {
			dp[i] = i;
			
			for(int j = 1; j*j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-(j*j)] + 1);
			}
		}
		
		System.out.print(dp[n]);
	}

}
