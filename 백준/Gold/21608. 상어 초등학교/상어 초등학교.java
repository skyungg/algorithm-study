import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int count;		// 좋아하는 학생수
		int empty;		// 비어있는 칸
		
		public Point(int x, int y, int count, int empty) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.empty = empty;
		}
		
		/* 정렬
		 * 1. 인접칸(4방향)에 좋아하는 학생 수가 더 많은 순
		 * 2. 인접 칸 중 비어있는 칸이 가장 많은 순
		 * 3. 행, 열  작은 순
		 * */
		@Override
		public int compareTo(Point p) {
			if(p.count == this.count) {
				if(p.empty == this.empty) {
					if(p.x == this.x) return this.y - p.y;
					else return this.x - p.x;
				}else return p.empty - this.empty;
			}else return p.count - this.count;
		}
	}
	
	static int N;
	static int [][] map;
	static List<List<Integer>> list = new ArrayList<>();
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i <= N*N; i++) {
			list.add(new ArrayList<>());
		}
		
		// 입력
		StringTokenizer st;
		for(int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < 4; j++) {
				list.get(num).add(Integer.parseInt(st.nextToken()));
			}
			
			// 자리배치 하기
			bfs(num);
		}
		
		// 만족도 조사
		int score = 0;
//		int [] cost = {0, 1, 10, 100, 1000};
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int target = map[i][j];		// 기준 학생
				
				int cnt = 0;
				for(int idx = 0; idx < 4; idx++) {
					int tx = i + dx[idx];
					int ty = j + dy[idx];
					
					if(checkRange(tx, ty) && list.get(target).contains(map[tx][ty])) {	// 범위 내 있음
						cnt++;
					}
				}
				
				// 점수 계산
				if(cnt > 0) {
					score += (int)Math.pow(10, (cnt-1));
					
				}
				
				
			}
		}
		
		System.out.println(score);

	}
	
	static void bfs(int num) {
		int [] result = {-1, -1, 21, 21};	// 좋아하는 학생수, 비어있는 칸, 행, 열 초기값 셋팅
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					// 비어있는 경우 -> 현재 위치를 중점으로 탐색 
					int cnt = 0;	// 좋아하는 학생 수
					int empty = 0;	// 비어있는 칸 수
					
					for(int idx = 0; idx < 4; idx++) {
						int tx = i + dx[idx];
						int ty = j + dy[idx];
						
						if(checkRange(tx, ty)) {	// 범위 내 있음
							if(map[tx][ty] == 0) {		// 비어있는 경우
								empty++;
							}else {
								if(list.get(num).contains(map[tx][ty])) {	// 좋아하는 학생 수경우
									cnt++;
								}
							}
						}
						
					}
					
					// 위치 갱신 판단하기
					if(cnt > result[0]) {		// 좋아하는 학생수가 더 많음 -> 갱신 
						result[0] = cnt;
						result[1] = empty;
						result[2] = i;
						result[3] = j;
					}else if(cnt == result[0]) {
						if(empty > result[1]) {
							result[0] = cnt;
							result[1] = empty;
							result[2] = i;
							result[3] = j;
						}else if(empty == result[1]) {
							if(i < result[2]) {
								result[0] = cnt;
								result[1] = empty;
								result[2] = i;
								result[3] = j;
							}else if(i == result[2]) {
								if(j < result[3]) {
									result[0] = cnt;
									result[1] = empty;
									result[2] = i;
									result[3] = j;
								}
							}
						}
					}
				}
				
			}
		}
		
		// 자리 확정하기
		map[result[2]][result[3]] = num;
		
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N; 
	}

}
