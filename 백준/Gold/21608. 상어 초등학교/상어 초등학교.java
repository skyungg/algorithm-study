import java.io.*;
import java.util.*;

public class Main {
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
						result = update(cnt, empty, i, j);
					}else if(cnt == result[0]) {
						if(empty > result[1]) {
							result = update(cnt, empty, i, j);
						}else if(empty == result[1]) {
							if(i < result[2]) {
								result = update(cnt, empty, i, j);
							}else if(i == result[2]) {
								if(j < result[3]) {
									result = update(cnt, empty, i, j);
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
	
	static int [] update(int cnt, int empty, int x, int y) {
		return new int[] {cnt, empty, x, y};
	}
}
