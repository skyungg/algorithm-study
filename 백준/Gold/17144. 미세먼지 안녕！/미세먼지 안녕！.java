import java.io.*;
import java.util.*;

public class Main {
	static int r;
	static int c;
	static int [][] map;
	static int t;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					list.add(i);
				}
			}
		}
		
		// 구현
		for(int i = 0; i < t; i++) {
			// 1. 미세먼지 확산
			spreadDust();
			
			// 2. 공기청정기 작동
			workAirUp(list.get(0));
			workAirDown(list.get(1));
		}
		
		// 합산
		int answer = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != -1) answer += map[i][j];
			}
		}
		
		System.out.println(answer);
	}
	
	static void spreadDust() {
		int [][] tmp = new int[r][c];
		int [] dx = {-1, 0, 1, 0};
		int [] dy = {0, 1, 0, -1};
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != -1) {
					int amount = map[i][j]/5;
					int cnt = 0;
					
					for(int k = 0; k < 4; k++) {
						int tx = i + dx[k];
						int ty = j + dy[k];
						
						if(tx >= 0 && tx < r && ty >= 0 && ty < c && map[tx][ty] != -1) {
							tmp[tx][ty] += amount;
							cnt++;
						}
					}
					tmp[i][j] += map[i][j] - (amount*cnt);
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != -1) {
					map[i][j] = tmp[i][j];
				}
			}
		}
		
	}
	
	static void workAirUp(int sx) {
		// 1. from left to right	(행 고정, 열 이동)
		int pre = 0;
		int cur = 0;
		
		for(int i = 1; i < c; i++) {
			cur = map[sx][i];
			map[sx][i] = pre;
			pre = cur;
		}
		
		// 2. from down to up ( 행 이동, 열 고정)
		for(int i = sx-1; i >= 0; i--) {
			cur = map[i][c-1];
			map[i][c-1] = pre;
			pre = cur;
		}
		
		// 3. from right to left ( 행 고정, 열 이동)
		for(int i = c-2; i >= 0; i--) {
			cur = map[0][i];
			map[0][i] = pre;
			pre = cur;
		}
		
		// 4. from up to down (행 이동, 열 고정)
		for(int i = 1; i <= sx; i++) {
			cur = map[i][0];
			map[i][0] = pre;
			pre = cur;
		}
		map[sx][0] = -1;
	}
	
	static void workAirDown(int sx) {
		// 1. from left to right	(행 고정, 열 이동)
		int pre = 0;
		int cur = 0;
		for(int i = 1; i < c; i++) {
			cur = map[sx][i];
			map[sx][i] = pre;
			pre = cur;
		}
		
		// 2. from up to down 		(행 이동, 열 고정)
		for(int i = sx+1; i < r; i++) {
			cur = map[i][c-1];
			map[i][c-1] = pre;
			pre = cur;
		}
		
		// 3. from right to left 		(행 고정, 열 이동)
		for(int i = c-2; i >= 0; i--) {
			cur = map[r-1][i];
			map[r-1][i] = pre;
			pre = cur;
		}
		
		// 4. from down to up ( 행 이동, 열 고정)
		for(int i = r-2; i > sx; i--) {
			cur = map[i][0];
			map[i][0] = pre;
			pre = cur;
		}
		map[sx][0] = -1;
	}
}
