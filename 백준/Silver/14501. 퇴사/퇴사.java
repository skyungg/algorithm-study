import java.io.*;
import java.util.*;

/*
 * (구) 백준이가 얻을 수 있는 최대 이익
 * */

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] T = new int[N+1];	// 상담 기간
		int [] P = new int[N+1];	// 상담 비용
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] dp = new int[N+2];	//  N일에 하루만해서 상담 끝냈을 때 N+1로 계산되니까
		for(int i = 1; i <= N; i++) {
			// 오늘 상담을 안 하는 경우 
			dp[i] = Math.max(dp[i], dp[i-1]);
			
			// 오늘 상담함
			if(T[i]+i <= N+1) {			// 오늘 상담했을 때, 퇴사일까지 상담 가능
				dp[T[i]+i] = Math.max(dp[T[i]+i], dp[i]+P[i]);
			}
		}
		
		int count = 0;
		for(int result : dp) {
			count = Math.max(count, result);
		}
		
		System.out.println(count);
	}

}
