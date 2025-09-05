import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static List<Point> list;	// 블록 그룹
	static int standard_x, standard_y, rainbow_block, general_block;
	static boolean [][] visited;
	static int total_score = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int idx = 0;
		while(true) {
			// 초기화
			list = new LinkedList<>();
			standard_x = 21;
			standard_y = 21;
			rainbow_block = 0;	
			general_block = 0;
			visited = new boolean[N][N];	// 방문 배열
			
//			System.out.println(idx++ +"번째 ----------");
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			// 1. 블록 구역
			find_block();
			
			if(list.size() <= 1 || general_block == 0) break;	// 블록 그룹 존재X or 일반 블록 X
			
			cal_score();
			
			// 2. 중력
			gravitate();
			
			// 3. 반시계방향 90도 회전하기
			rotate_90();
			
			// 4. 중력
			gravitate();
		}
		
		System.out.println(total_score);
	}
	
	static void find_block() {
		/*
		 * [description] 가장 크기가 큰 블록 그룹 찾기
		 * */
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] > 0 && !visited[i][j]) {	// 일반 block이 꼭 속해야 하니까
					
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		
	}
	
	
	static void bfs(int x, int y) {
		List<Point> tmp_list = new LinkedList<>();
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x, y));
		tmp_list.add(new Point(x, y));
		int color = map[x][y];
		
		boolean [][] cur_visited = new boolean[N][N];	// 무지개 블록 제외하고 방문 표시할 배열
		cur_visited[x][y] = true;
		
		int sx = x;		// 현재 위치에서 만들 블록그룹에서, 초기 기준 위치
		int sy = y;
		int rcnt = 0;	// 무지개 블록 수
		int gcnt = 1;	// 일반 블록 수
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				
				if(check_ragne(tx, ty) && !cur_visited[tx][ty] && (map[tx][ty] == 0 || map[tx][ty] == color)) {
					que.add(new Point(tx, ty));
					cur_visited[tx][ty] = true;
					tmp_list.add(new Point(tx, ty));
					
					if(map[tx][ty] == 0) rcnt++;		// 무지개 블록인 경우
					else if(map[tx][ty] > 0) {			// 일반 블록인 경우
						if((tx < sx) || (tx == sx && ty < sy)) {		// 현재 그룹 내에서 기준 블록 찾기
							sx = tx;
							sy = ty;
						}
						gcnt++;
						visited[tx][ty] = true;
					}
				}
			}
		}
		
		// 방문 확인 처리하기
//		for(int i = 0; i < N; i ++) {
//			for(int j = 0; j < N; j++) {
//				if(cur_visited[i][j] && map[i][j] > 0) {	// 일반 블록만 방문 처리하기
//					visited[i][j] = true;	
//				}
//			}
//		}
		
		// 최대 블록 그룹 찾기
		if(tmp_list.size() == 0 || gcnt == 0) return;	// 블록 성립 X
		
		if(tmp_list.size() > list.size()) {		// 기존 블록 크기보다 큰 경우 -> 모든 값 갱신
			update_group(tmp_list, sx, sy, rcnt, gcnt);
		}else if(tmp_list.size() == list.size()) {
			if(rcnt > rainbow_block) {	// 기존 무지개 블록보다 많을 경우 ->업데이트
				update_group(tmp_list, sx, sy, rcnt, gcnt);
			}else if(rcnt == rainbow_block) {
				if(sx > standard_x) {
					update_group(tmp_list, sx, sy, rcnt, gcnt);
				}else if(sx == standard_x) {
					if(sy > standard_y) {
						update_group(tmp_list, sx, sy, rcnt, gcnt);
					}
				}
			}
			
		}
	}
	
	static void cal_score() {
		/*
		 * [description] 점수 계산하기
		 * */
		
		int count = list.size();
		total_score += (count*count);

		// 해당 좌표 삭제 처리하기
		for(Point p : list) {
			map[p.x][p.y] = -2;
		}
	}
	
	static void update_group(List<Point> tmp, int x, int y, int rcnt, int gcnt) {
		standard_x = x;
		standard_y = y;
		rainbow_block = rcnt;
		general_block = gcnt;
		list.clear();
		list = tmp;
	}
	
	static boolean check_ragne(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	static void rotate_90() {
		/*
		 * [description] 반시계 방향으로 90도 2차원 배열 회전하기
		 * 1. 기존 열 -> 행 (마지막 열 -> 첫 행: N-c-1)
		 * 2. 기존 행 -> 열
		 * */
		int [][] tmp_map = new int[N][N];
		for(int c = 0; c < N; c++) {
			for( int r = 0; r < N; r++) {
				tmp_map[N-c-1][r] = map[r][c];
			}
		}
		map = tmp_map.clone();
	}
	
	static void gravitate() {
		/*
		 * 1. 열 중심으로, 가장 마지막 행부터 진행
		 * 2. 검은색 블록(-1)은 적용 X
		 * 3. 다른 블록 or 격자 경계 만나기 전까지 이동
		 * */
		
		for(int c = 0; c < N; c++) {
			for(int r = N-1; r >= 0; r--) {
				if(map[r][c] == -1) continue;	// 검은색 블록 적용 X
				int cur_r = r;	// 현재 행
				while(true) {
					if((cur_r+1) < N && map[cur_r+1][c] == -2) {	// (다음 행이 범위 내 위치 + 빈 공간인 경우)  -> 다음 행으로 값 갱신
						cur_r++;
					}else break;	// 더 이상 이동 불가능
				}
				if(cur_r != r) {
					map[cur_r][c] = map[r][c];	// 중력이 작용한 최종 위치로 이동
					map[r][c] = -2;	// 빈 공간처리
				}
			}
		}
	}

}
