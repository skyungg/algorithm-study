import java.io.*;
import java.util.*;

public class Main {
	static int N, Q;
	static int double_n;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 초기값 셋팅
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		double_n = convert(N);
		map = new int[double_n][double_n];
		for(int i = 0; i < double_n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < double_n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 2. 파이어 스톰 시전
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q; i++) {
			int num = Integer.parseInt(st.nextToken());
			rotate(num);	// 90도 회전하기
			reduce_ice();		// 얼음 감소
		}
		
		// 3. 정답 구하기
		// (1) 남아 있는 합
		int sum = 0;
		for(int i = 0; i < double_n; i++) {
			for(int j = 0; j < double_n; j++) {
				sum += map[i][j];
			}
		}
		int max_area = 0;
		visited = new boolean[double_n][double_n];
		for(int i = 0; i < double_n; i++) {
			for(int j = 0; j < double_n; j++) {
				if(map[i][j] > 0 && !visited[i][j]) {
					max_area = Math.max(max_area, countArea(i, j));
				}
			}
		}
		
		// 정답 출력
		System.out.println(sum+"\n"+max_area);
	}
	
	static void rotate(int num) {
		// 1. 90도 
		int s = convert(num);
		int [][] tmp = new int[double_n][double_n];
		
		
		for(int r = 0; r < double_n; r += s) {	// 블록 시작점
			for(int c = 0; c < double_n; c += s) {
				// 블록 내부 좌표 돌기
				for (int i = 0; i < s; i++) {
	                for (int j = 0; j < s; j++) {
	                    tmp[r + j][c + (s - 1 - i)] = map[r + i][c + j];
	                }
	            }
			}
		}
		
		for (int i = 0; i < double_n; i++) {
	        System.arraycopy(tmp[i], 0, map[i], 0, double_n);
	    }
		
	}
	
	static void reduce_ice() {
		// 얼음 감소량 
		Queue<int []> que = new LinkedList<>();
		for(int i = 0; i < double_n; i++) {
			for(int j = 0; j < double_n; j++) {
				if(map[i][j] > 0) {
					int cnt = 0;	// 현재 칸을 기준으로 인접한 칸의 개수
					for(int k = 0; k < 4; k++) {
						int tx = i + dx[k];
						int ty = j + dy[k];
						
						if(checkRange(tx, ty) && map[tx][ty] > 0) {
							cnt++;
						}
					}
					if(cnt < 3) que.add(new int[] {i, j});	// 감소 시켜야할 위치
				}
			}
		}
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			map[point[0]][point[1]] -= 1;
		}
	}
	
	static int convert(int n) {
		return (int) Math.pow(2, n);
	}
	
	static int countArea(int x, int y) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {x, y});
		int tmp_area = 1;	// 현재 이어진 얼음 개수
		visited[x][y] = true;	// 초기 위치 방문 처리
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(checkRange(tx, ty) && map[tx][ty] > 0 && !visited[tx][ty]) {
					visited[tx][ty] = true;
					que.add(new int[] {tx, ty});
					tmp_area++;
				}
			}
		}
		
		return tmp_area;
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < double_n && y >= 0 && y < double_n;
	}

}
