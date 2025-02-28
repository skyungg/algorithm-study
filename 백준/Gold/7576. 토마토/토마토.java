import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int x;
		int y;
		int time;
		
		public Point(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	
	static int n, m;
	static int [][] map;
	static ArrayList<int []> list = new ArrayList<>();
	static Queue<Point> que = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) que.add(new Point(i, j, 0));
				}
		}
		
		
		// 1. 토마토 후숙
		int result = bfs();
		
		// 2. 토마토 결과
		boolean flag = true;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					
					flag = false;
					break;
				}
			}
			if(!flag) break;
		}
		
		if(!flag) System.out.println(-1);
		else System.out.println(result);
	}
	
	static int bfs() {
		int dx [] = {-1, 0, 1, 0};
		int dy [] = {0, 1, 0, -1};
		
		boolean [][] visited = new boolean[n][m];
		
		int result = 0;
		while(!que.isEmpty()) {
			Point p = que.poll();
			visited[p.x][p.y] = true;
			
			result = Math.max(result,  p.time);
			
			for(int i = 0; i < 4; i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				
				if(tx >= 0 && tx < n && ty >= 0 && ty < m) {
					if(map[tx][ty] == 0 && !visited[tx][ty]) {
						map[tx][ty] = 1;
						que.add(new Point(tx, ty, p.time+1));
					}
				}
			}
		}
		return result;
	}

}
