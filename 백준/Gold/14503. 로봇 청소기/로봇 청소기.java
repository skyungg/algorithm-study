import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	static int result = 0;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());		// 바라보는 방향
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(x, y, d);
		
		System.out.println(result);
	}
	static void dfs(int x, int y, int d) {
		// 현재 칸 청소
		if(map[x][y] == 0) {
			map[x][y] = -1;
			result++;
		}
		
		for(int i = 0; i < 4; i++) {
			d = (d+3) % 4;	// 방향 조작
			int tx = x + dx[d];
			int ty = y + dy[d];
			
			if(tx >= 0 && tx < N && ty >= 0 && ty  < M) {
				if(map[tx][ty] == 0) {
					// 청소해야 하는 칸 발견
					dfs(tx, ty, d);
					return;
				}
			}
		}
		
		// 현재 위치 기준 4방탐색 끝
		int cx = x - dx[d];
		int cy = y - dy[d];
		
		if((cx >= 0 && cx < N && cy >= 0 && cy  < M) && map[cx][cy] == 1) return;
		
		dfs(cx, cy, d);
	}
}
