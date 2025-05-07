import java.io.*;
import java.util.*;
/*
 * 아이디어: 그래프 탐색 + 구현
 * 1. 종수는 특정 방향으로만 이동
 * 2. 초기 미친 아두이노 위치 저장
 * 3. 종수의 위치 먼저 움직이기 -> 미친 아두이노와의 접점 판단
 * 4. 3이후 두 아두이노 사이의 거리 구해서 움직이기 -> 접점 판단
 * */
public class Main {
	static int r, c;
	static int [] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int [] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	static String [][] map;
	static int [] op;
	static Queue<Point> que = new LinkedList<>();
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new String[r][c];
		int [] start = new int[2];

		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().split("");
			for(int j = 0; j < c; j++) {
				if(map[i][j].equals("I")) {
					start[0] = i;
					start[1] = j;
				}
				if(map[i][j].equals("R")) {
					que.add(new Point(i, j));
				}
			}
		}

		String [] tmp = br.readLine().split("");
		op = new int[tmp.length];
		for(int i = 0; i < tmp.length; i++) {
			op[i] = Integer.parseInt(tmp[i])-1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < op.length; i++) {
			start = robots(start, op[i]);
			
			if(start[0] == -1 && start[1] == -1) {
				sb.append("kraj "+(i+1));
				break;
			}
			
		
		}
		
		// 정답 출력
		if(sb.toString().length() > 0) System.out.println(sb.toString());
		else {
			for(String [] arr : map) {
				for(String ar : arr) {
					sb.append(ar);
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
		}
	}
	
	static int [] robots(int [] start, int op) {
		// 1. 종수 위치 변경
		int tx = start[0] + dx[op];
		int ty = start[1] + dy[op];
		
		if(!checkRange(tx, ty)) return new int[] {-1, -1};		// 범위 체크
		if(map[tx][ty].equals("R")) return new int[] {-1, -1};	// 이동한 위치가 미친 아두이노가 위치한 칸일 경우
					
		map[start[0]][start[1]] = ".";
		
		// 2. 미친 아두이노 움직이기
		Queue<Point> tmpQue = new LinkedList<>();
		
		int [][] cnt = new int[r][c];
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			int minDis = Integer.MAX_VALUE;

			int tmpX = 0;
			int tmpY = 0;
			// (1) 종수와 현재 아두이노 사이의 거리가 가장 짧은 위치 찾기
			for(int idx = 0; idx < 9; idx++) {
				if(idx == 4) continue;	// 5 방향은 제외
				
				int ax = p.x + dx[idx];
				int ay = p.y + dy[idx];
				
				if(!checkRange(ax, ay)) continue;	// 범위 확인
				int distance = calculateDistance(tx, ty, ax, ay);
				if(distance < minDis) {
					tmpX = ax;
					tmpY = ay;
					minDis = distance;
				}			
			}
			
			cnt[tmpX][tmpY]++;	// 이동한 위치 표시
		}
		
		// (2) 아두이노 한번에 이동하기
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(cnt[i][j] >= 1 && i == tx && j == ty) return new int[] {-1, -1}; // 이동한 위치가 종수 아두이노와 겹침	
				
				if(cnt[i][j] == 1) {				
					map[i][j] = "R";
					tmpQue.add(new Point(i, j));
				}else if(cnt[i][j] > 1) {
					map[i][j] = ".";		// 아두이노 폭발
				}else if(!map[i][j].equals("I")) {
					map[i][j] = ".";
				}
			}
		}
		que = tmpQue;
		map[tx][ty] = "I";		// 종수 완전 변경
		return new int [] {tx, ty};
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}
	
	static int calculateDistance(int r1, int s1, int r2, int s2) {
		return Math.abs(r1-r2) + Math.abs(s1-s2);
	}

}
