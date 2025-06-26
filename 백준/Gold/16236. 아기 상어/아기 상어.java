import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int distance;
		int x;
		int y;
		
		public Point(int distance, int x, int y) {
			this.distance = distance;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point p) {
			if(this.distance == p.distance) {
				if(this.x == p.x) return this.y - p.y;
				else return this.x - p.x;
			}else return this.distance - p.distance;
		}
	}
	
	static int N;
	static int [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int babyShark = 2;	// 아기상어 초기 크기
	static int curX = 0;	// 현재 아기상어 위치
	static int curY = 0;
	static int minTime = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 크기
		map = new int[N][N];
		
		// 초기 상태 입력
		int sx = 0;		// 상어 위치
		int sy = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9){
					curX = i;
					curY = j;
					map[i][j] = 0;
				}
			}
		}
		
		// 아기 상어 탐색 시작
		start();
		
		// 정답 출력
		System.out.println(minTime);

	}
	
	static void start() {
		PriorityQueue<Point> curPq = new PriorityQueue<>();		// 탐색하면서 쓸 pq
		PriorityQueue<Point> storePq = new PriorityQueue<>();	// 후처리 할 pq
		
		boolean [][] visited = new boolean[N][N];
		visited[curX][curY] = true;
		curPq.add(new Point(0, curX, curY)); 	// 현재 거리, 위치
		
		// 1. 아기상어가 움직일 수 있는 경로 구하기
		while(!curPq.isEmpty()) {
			Point p = curPq.poll();		// 현재 위치
			
			for(int i = 0; i < 4; i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				
				if(checkRange(tx, ty)){
					if(!visited[tx][ty]&& map[tx][ty] <= babyShark) {
						curPq.add(new Point(p.distance+1, tx, ty));
						if(map[tx][ty] < babyShark) {		// 잡아 먹을 수 있는 물고기 위치만 저장
							storePq.add(new Point(p.distance+1, tx, ty));
						}
						visited[tx][ty] = true;
					}
				}
			}
		}
		
		// 2. 1에서 구한 곳 중, 물고기 잡어먹기
		int cnt = 0;
		if(storePq.isEmpty()) return;
		
		Point sp = storePq.poll();
		
		if(map[sp.x][sp.y] > 0 && map[sp.x][sp.y] < babyShark) {
			map[sp.x][sp.y] = 0;	// 해당 위치 물고기 먹기
			minTime += newDistance(curX, curY, sp.x, sp.y);
//			minTime += sp.distance + preDistance;
//			preDistance = sp.distance;
			curX = sp.x;
			curY = sp.y;
			cnt++;
		}
		
		// 현재 babyShark의 크기만큼 cnt가동하기
		while(cnt < babyShark) {
			if(storePq.isEmpty()) break;
			
			int cx = 0;
			int cy = 0;
			int cDis = Integer.MAX_VALUE;
			PriorityQueue<Point> tPque = new PriorityQueue<>();
			
			while(!storePq.isEmpty()) {
				Point tp = storePq.poll();
				
				if(map[tp.x][tp.y] > 0 && map[tp.x][tp.y] < babyShark) {
					int curDistance = newDistance(curX, curY, tp.x, tp.y);
					tPque.add(new Point(curDistance, tp.x, tp.y));
				}
			}
			
			if(!tPque.isEmpty()) {
				Point cp = tPque.poll();
				minTime += cp.distance;
				map[cp.x][cp.y] = 0;	// 해당 위치 물고기 먹기
				curX = cp.x;
				curY = cp.y;
				cnt++;
			}
			
			if(tPque.isEmpty()) break;
			
			storePq = new PriorityQueue<>(tPque);
		}
		
		if(cnt == babyShark) {
			babyShark++;		// 아기 상어 크기 만큼 물고기 먹음 -> 아기상어 몸 키우기
			start();		// 현재 위치를 기준으로 다시 시작
		}
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	static int newDistance(int sx, int sy, int ex, int ey) {
		PriorityQueue<Point> pq = new PriorityQueue<>();		// 탐색하면서 쓸 pq
		pq.add(new Point(0, sx, sy));
		boolean [][] visited = new boolean[N][N];
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(p.x == ex && p.y == ey) {
				return p.distance;
			}
			
			for(int i = 0; i < 4; i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				
				if(checkRange(tx, ty)){
					if(!visited[tx][ty]&& map[tx][ty] <= babyShark) {
						pq.add(new Point(p.distance+1, tx, ty));
						visited[tx][ty] = true;
					}
				}
			}
		}
		
		return 0;
	}

}
