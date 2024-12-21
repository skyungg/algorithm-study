import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int map [][] = new int[n][m];
		int [][] distance = new int[n][m];
		Queue<int[]> que = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					que.add(new int[] {i, j});		// que에 상어가 있는 위치 넣기
					distance[i][j] = 0;
				}else {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		bfs(map, que, n, m, distance);
		int maxDis = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				maxDis = Math.max(maxDis, distance[i][j]);
			}
		}
		System.out.println(maxDis);
	}
	
	static void bfs(int[][] map, Queue<int[]> que, int n, int m, int[][] distance) {
		int [] dx = {0, -1, -1, -1, 0, 1, 1, 1};	
		int [] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
		
		while(!que.isEmpty()) {
			int [] cur = que.poll();
			
			for(int i = 0; i < 8; i++) {
				int tx = cur[0] + dx[i];
				int ty = cur[1] + dy[i];
				
				if(tx >= 0 && tx < n && ty >= 0 && ty < m && 
						(distance[tx][ty] > distance[cur[0]][cur[1]] + 1)) {
					distance[tx][ty] = distance[cur[0]][cur[1]] + 1;
					que.add(new int[] {tx, ty});
				}
			}
		}
	}
}
