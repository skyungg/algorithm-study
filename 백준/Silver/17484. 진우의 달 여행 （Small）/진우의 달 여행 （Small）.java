/*
 * 아이디어 : Queue 탐색
 * 1. Point 클래스 생성 -> x, y, dir(방향)
 * 2. Queue에서 탐색할 때 dir은 제외하고 탐색하기
 * 
 * */

import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int x;
		int y;
		int dir;
		int cost;
		
		public Point(int x, int y, int dir, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}
	
	static int n, m;
	static int [][] map;
	static int answer = Integer.MAX_VALUE;
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
			}
		}
		
		for(int i = 0; i < m; i++) {
			bfs(0, i);
		}
		
		System.out.println(answer);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList();
		que.add(new Point(x, y, -1, map[x][y]));
	
		int [] dx = {1, 1, 1};
		int [] dy = {-1, 0, 1};
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			if(p.x == n-1) {
				answer = Math.min(answer,  p.cost);
				continue;
			}
			
			for(int i = 0; i < 3; i++) {
				if(i == p.dir) continue;	// 이전 진행방향은 X
				
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				
				if(tx >= 0 && tx < n && ty >= 0 && ty < m) {
					que.add(new Point(tx, ty, i, p.cost + map[tx][ty]));
				}
			}
		}
	}

}
