import java.io.*;
import java.util.*;

/*
 * 아이디어 : dp
 * dp에 뭘 저장?
 * -> dp[x][y]는  (x, y)에서 (n-1, m-1)까지 도착하는 경로의 수
 * 1. dp[x][y] -> (x,y)에서 도착지까지의 경로수
 * */

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
				dp[i][j] = -1;
			}
		}
		
		// 그래프 탐색
		System.out.println(dfs(0, 0));
		
	}
	
	static int dfs(int x, int y) {
		if(x== n-1 && y == m-1) {	// 도착
			return 1;
		}
		
		if(dp[x][y] != -1) {
			return dp[x][y];	
		}
		
		dp[x][y] = 0;
		
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx < 0 || tx >= n || ty < 0 || ty >= m) continue;		// 범위확인
			if(map[tx][ty] < map[x][y]) {
				dp[x][y] += dfs(tx, ty);	
			}
		}
		
		return dp[x][y];
	}

}
