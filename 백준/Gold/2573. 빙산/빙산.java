import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int [][] map;
	static boolean [][] checked;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
//	static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				if(map[i][j] != 0) list.add(new int[] {i, j});
			}
		}
		
		int result = 0;
		while(true) {
			// 반복문 조건
			boolean[][] visited = new boolean[n][m];
			checked = new boolean[n][m];
			
			// 빙산 축소
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] != 0) {
						// 4방 탐색
						for(int k = 0; k < 4; k++) {
							int tx = i + dx[k];
							int ty = j + dy[k];
							
							if(tx >= 0 && tx < n && ty >= 0 && ty < m && !visited[tx][ty]) {
								if(map[tx][ty] == 0) {
									if(map[i][j] == 1) {
										map[i][j] = 0;
										visited[i][j] = true;
										break;
									}else {
										map[i][j] -= 1;		// 빙산 축소
									}
								}
							}
						}
					}
				}
			}
			
			int cnt = 0;
			// 덩어리 확인
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] > 0 && !checked[i][j]) {
						cnt += bfs(i, j);
					}
				}
			}
			
			result++;
			
			if(cnt > 1) {
				break;
			}
			else if(cnt == 0) {
				result = 0;
				break;
			}
		}
		System.out.println(result);	
	}

	static int bfs(int x, int y) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int[] {x, y});
		checked[x][y] = true;
		int cnt = 1;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(tx >= 0 && tx < n && ty >= 0 && ty < m && !checked[tx][ty]) {
					if(map[tx][ty] > 0) {
						cnt++;
						checked[tx][ty] = true;
						que.add(new int[] {tx, ty});
					}
				}
			}
		}
		
		
		if(cnt > 0) return 1;
		else return 0;
	}
}
