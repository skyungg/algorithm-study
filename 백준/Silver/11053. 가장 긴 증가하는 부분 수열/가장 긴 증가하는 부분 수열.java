import java.io.*;
import java.util.*;

/*
 * 아이디어 : 완전탐색 (실패) -> DP
 * -> dp[i]에는 뭘 저장하는가? i번째 수로 끝나는 증가하는 수열의 가장 긴 길이
 * */

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
		
		// 구현 -> 완전탐색
		int [] dp = new int[n];
		int maxLength = 1;
		dp[0] = 1;	// 첫 번째 원소는 자기 자신만 포함
		for(int i = 1; i < n; i++) {
			int tmpLength = 0;
			for(int j = i-1; j >= 0; j--) {
				if(arr[j] < arr[i]) {
					tmpLength = Math.max(tmpLength, dp[j]);
				}
			}
			
			if(tmpLength == 0) dp[i] = 1;	// 자기 자신만 존재
			else dp[i] = tmpLength+1;
			
			maxLength = Math.max(maxLength, dp[i]);
		}
		
		System.out.println(maxLength);

	}

}
