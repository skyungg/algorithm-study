/*
 * 초기 아이디어 : dfs
 * 결과 : n,m 최악의 결과 시간초과 발생
 * 
 * 힌트 아이디어 : dp + dfs
 * 1. dp[x][y] -> (x,y)에서 도착지까지의 경로수
 * */
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int [][] map, dp;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;		// 초기화  -1
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	static int dfs(int x, int y) {
		if(x == n-1 && y == m-1) {
			return 1;		// 목표 지점 도달 -> 경로 1개 발견
		}
		
		if(dp[x][y] != -1) {		// 이미 (x, y)에서 도착지까지 경로를 구함!
			return dp[x][y];
		}
		
		dp[x][y] = 0; // 초기화

		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx >= 0 && tx < n && ty >= 0 && ty < m) {
				if(map[tx][ty] < map[x][y]) {
					dp[x][y] += dfs(tx, ty);
				}
			}
		}
		
		return dp[x][y];
	}

}
