/*
 * 아이디어: 그래프
 * "." : 비어있는곳, "*": 물, "X": 돌, "D": 비버굴, "S":고슴도치 위치  
 * */
import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static Queue<int []> waterQueue = new LinkedList<>();
	static int [][] waterTime;		// 물이 각 칸에 도달하는 시간
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int sx = 0;
		int sy = 0;
		map = new char[R][C];
		waterTime = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);	
				if(map[r][c] == 'S') {
					sx = r;
					sy = c;
				}else if(map[r][c] == '*') {	// 물 위치
					waterTime[r][c] = 1;	
					waterQueue.add(new int [] {r, c});
				}
			}
		}
		
		// 탐색
		int time = bfs(sx, sy);
		
		// 결과 출력 
		if(time == -1) System.out.println("KAKTUS");
		else System.out.println(time);
	}
	
	static int bfs(int x, int y) {
		// 1. 물 확산하기
		while(!waterQueue.isEmpty()) {
			int [] water = waterQueue.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = water[0] + dx[i];
				int ty = water[1] + dy[i];
				
				if(!checkRange(tx, ty)) continue;	// 범위 밖
				if(waterTime[tx][ty] != 0) continue;		// 이미 방문
				if(map[tx][ty] == 'D' || map[tx][ty] == 'X') continue;	// 비버굴, 돌 -> 확산 불가능
				
				waterTime[tx][ty] = waterTime[water[0]][water[1]] + 1;
				waterQueue.add(new int[] {tx, ty});
			}
		}


		// 2. 고슴도치 이동하기
		Queue<int []> hQueue = new LinkedList<>();
		boolean [][] visited = new boolean[R][C];
		visited[x][y] = true;
		
		hQueue.add(new int[] {x, y, 1});
		
		while(!hQueue.isEmpty()) {
			int [] point = hQueue.poll();
			
			if(map[point[0]][point[1]] == 'D') {
				return point[2] - 1;		// 비버굴 도착 
			}
		
			// 고슴도치 이동하기
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(!checkRange(tx, ty)) continue;	// 범위 밖
				if(visited[tx][ty]) continue;		// 이미 방문함
				if(map[tx][ty] == 'X') continue;	// 돌 위치는 이동X
				
				// 비버굴
				if(map[tx][ty] == 'D') {
					visited[tx][ty] = true;
					hQueue.add(new int [] {tx, ty, point[2]+1});
					continue;
				}
				
				// 이동하려는 위치가 빈칸 -> 물이 도착하는 시간보다 빨라야함
				if(map[tx][ty] == '.') {
					if(waterTime[tx][ty] != 0 && waterTime[tx][ty] <= point[2]+1) continue;
					
					visited[tx][ty] = true;
					hQueue.add(new int [] {tx, ty, point[2]+1});
				}
			}
		}
		
		return -1;	// 비버굴 도착 불가
		
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
