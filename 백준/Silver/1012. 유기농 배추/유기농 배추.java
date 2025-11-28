import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		// 수빈이 위치
				
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			 st = new StringTokenizer(br.readLine());
			 M = Integer.parseInt(st.nextToken());
			 N = Integer.parseInt(st.nextToken());
			 int K = Integer.parseInt(st.nextToken());
			 
			 map = new int[N][M];
			 visited = new boolean[N][M];
			 
			 for(int k = 0; k < K; k++) {
				 st = new StringTokenizer(br.readLine());
				 int y = Integer.parseInt(st.nextToken());
				 int x = Integer.parseInt(st.nextToken());
				 map[x][y] = 1;
			 }
			 
			 // 탐방
			 int count = 0;
			 for(int i = 0; i < N; i++) {
				 for(int j = 0; j < M; j++) {
					 if(map[i][j] == 1 && !visited[i][j]) {
						 bfs(i, j);
						 count++;
						 
					 }
				 }
			 }
			 
			 sb.append(count+"\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(!checkRange(tx, ty)) continue;
				if(map[tx][ty] == 1 && !visited[tx][ty]) {
					visited[tx][ty] = true;
					que.add(new int[] {tx, ty});
				}
			}
		}
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
