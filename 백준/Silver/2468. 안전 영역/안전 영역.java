import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean [][] visited;
	static int [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int maxH = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		
		int result = 0;		// 최대 안전 영역 수
		
		for(int h = -1; h <= maxH; h++) {
			visited = new boolean[N][N];	// 각 높이별 방문 배열 생성
			int tmpSum = 0;		// 현재 높이에서 안전 영역 수
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] > h) {
						bfs(h, i, j);
						tmpSum++;
					}
				}
			}
			
			result = Math.max(result, tmpSum);
		}
		
		System.out.println(result);
		
	}
	
	static void bfs(int h, int x, int y) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(tx >= 0 && tx < N && ty >= 0 && ty < N) {
					if(!visited[tx][ty] && map[tx][ty] > h) {
						visited[tx][ty] = true;
						que.add(new int[] {tx, ty});
					}
				}
			}
		}

	}
	
}
