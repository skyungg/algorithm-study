/*
 * 아이디어 : dp
 * 1. 한 칸에 대해서 3 방향으로 설정 -> 3차원 배열
 * 2. 0은, 1,2 방향 중 최솟값, 1은 0,2 방향 중 최솟값, 2는 0,1 방향 중 최솟값 저장
 * 3. 마지막에 0, 1, 2중 최솟값이 정답
 * */
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// DP
		int [][][] dp = new int[n][m][3];	// 3방향
		// 첫 줄 값 셋팅
		for(int i = 0; i < m; i++) {
			dp[0][i][0] = map[0][i];
			dp[0][i][1] = map[0][i];
			dp[0][i][2] = map[0][i];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(j-1 >= 0 && j+1 < m) {	// 왼쪽 위, 오른쪽 위가 범위 내
					dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + map[i][j];
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) +  map[i][j];
					dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) +  map[i][j];
				}else if(j-1 >= 0) {	// 오른 쪽 위가 범위 밖 (왼쪽 위만 가능)
					dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) +  map[i][j];
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) +  map[i][j];
					dp[i][j][2] = Integer.MAX_VALUE;	
				}else if(j+1 < m) {	// 왼쪽 위가 범위 밖(오른쪽위만 가능)
					dp[i][j][0] = Integer.MAX_VALUE;
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) +  map[i][j];
					dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) +  map[i][j];
				}
			}
		}
		
		// 마지막 행 최솟값 선정
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < m; i++) {
			answer = Math.min(answer,  Math.min(dp[n-1][i][0], Math.min(dp[n-1][i][1], dp[n-1][i][2])));
		}
		
		// 정답 출력
		System.out.println(answer);
	}

}
