import java.io.*;
import java.util.*;

/*
 * 아이디어 : bfs + 가지치기..?
 * 1. 각 칸 이동시 가중치 1로 고정 -> 다익스트라는 아닌듯
 * 2. 불의 확산이 상근이 탈출이 동시에 일어남 -> 이걸 어떻게 구현할 것인지
 * 	-> 각각 bfs 돌리는데, 먼저 불의 확산 돌리고, 그 다음 이걸 이용해서 상근이 탈출하기
 * */

public class Main {
	static int h, w;
	static char [][] map;
	static int [][] fTime, sgTime;		// 불 이동 시간, 상근 이동시간
	static boolean [][] fireVisited, sgVisited;		// 불 방문, 상근 방문
	static Queue<int []> fQue = new LinkedList<>();
	static Queue<int []> sQue = new LinkedList<>();
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static StringBuilder sb = new StringBuilder();	// 초기화

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 0; t < T; t++) {
			// 0. 입력 받기
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			fTime = new int[h][w];		// 이동시간 
			sgTime = new int[h][w];
			fireVisited = new boolean[h][w];	// 방문여부
			sgVisited = new boolean[h][w];
			
			fQue.clear();
			sQue.clear();

			for(int i = 0; i < h; i++) {
				String str = br.readLine();
				for(int j = 0; j < w; j++){
					map[i][j] = str.charAt(j);
					fTime[i][j] = -1;	// 시간 배열 초기화 (최소 시간 구해야하니까 -1로)
					sgTime[i][j] = -1;
					
					if(map[i][j] == '@') {		// 상근이 위치
						sgTime[i][j] = 0;
						sgVisited[i][j] = true;
						sQue.add(new int[] {i, j});
					}
					if(map[i][j] == '*') {				// 불의 좌표, 시간
						fTime[i][j] = 0;
						fireVisited[i][j] = true;
						fQue.add(new int [] {i, j});
					}
				}
			}
			
			// 1. 탐색
			fireBfs();
			sgBfs();	// 상근이  탈출
		
		}
		
		// 2. 결과 출력
		System.out.println(sb.toString());

	}
	
	static void fireBfs() {
		while(!fQue.isEmpty()) {
			int [] curArr = fQue.poll();
			
			
			for(int i = 0; i < 4; i++) {
				int tx = curArr[0] + dx[i];
				int ty = curArr[1] + dy[i];
				
				if(checkRange(tx, ty) && !fireVisited[tx][ty] && map[tx][ty] != '#') {	// 범위 내 + 방문 전 + 벽 아닌곳
					fireVisited[tx][ty] = true;
					fTime[tx][ty] = fTime[curArr[0]][curArr[1]] + 1;	// 시간 갱신
					fQue.add(new int[] {tx, ty});
					
				}
			}
		}
	}
	
	static void sgBfs() {
		boolean flag = false;
		
		while(!sQue.isEmpty() && !flag) {
			int [] curArr = sQue.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = curArr[0] + dx[i];
				int ty = curArr[1] + dy[i];
				
				if(!checkRange(tx, ty)) {	// 범위 밖 -> 탈출 성공
					sb.append((sgTime[curArr[0]][curArr[1]]+1)+"\n");
					flag = true;
					break;
				}
				
				// 이동 불가
				if(map[tx][ty] == '#' || sgVisited[tx][ty]) continue;	// 벽 or 이미 상근이가 방문
				if(fTime[tx][ty] != -1  && fTime[tx][ty] <= sgTime[curArr[0]][curArr[1]]+1) continue;	//현재위치에서 불의 확산이 더 빠른경우
				
				// 이동 가능
				sgTime[tx][ty] = sgTime[curArr[0]][curArr[1]]+1;
				sgVisited[tx][ty] = true;
				sQue.add(new int[] {tx, ty});
			}
		}
		
		if(!flag) sb.append("IMPOSSIBLE\n");
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < h && y >= 0 && y < w;
	}

}
