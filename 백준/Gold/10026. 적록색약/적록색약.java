import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**2023-08-21
 * [문제] BJ : 10026 적록색약
 * [아이디어]
 * (구) 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하기
 * 
 * 1.먼저 초기 입력 받은 배열을 통해 적록색약이 아닌 사람이 봤을 때의 구역을 구한다.
 * 	>> dfs 탐색 이용
 * 2. 기존의 배열에서 G값을 R로 변경한다.	(적록색약이므로 R과 G는 동일하다)
 * 	>> 방문 배열도 다시 생성하다.
 * 3. dfs를 탐색할 때, 하나의  dfs가 끝날 때마다 구하는 구역의 값을 증가한다.
 * 
 * [주의]
 * 1. 배열을 더 만들지 않고 기존의 배열 재사용하기
 * 	>> R-G 바꾸기, 방문배열은 재할당
 * 2. DFS 함수도 하나로만 이용하기
 * 
 * 메모리 : 15732 KB
 * 시   간 : 	148 ms
 * @author 허승경
 *
 */
public class Main {
	static int N;
	static char [][] arr;
	static boolean [][] visited;
	//static boolean [][] visitedColor;
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1};
	
	static boolean check(int x, int y) {		// 변환된 값의 범위 확인
		
		if(x >= 0 && x < N && y >= 0 && y < N) {		// 범위 조건 만족할 경우 true 리턴
			return true;
		}
		return false;
	}
	
	static void findArea(int x, int y, char color) {
		
		int nx;
		int ny;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if(check(nx, ny) && !visited[nx][ny]) {
				if(arr[nx][ny] == color) {
					visited[nx][ny] = true;
					findArea(nx, ny, color);		// 변화된 값으로 탐색(재귀)
				}
			}
			
		}
		return;
		
	}
	
//	static void findAreaColor(int x, int y, char color) {
//		
//		int nx;
//		int ny;
//		for(int i = 0; i < 4; i++) {
//			nx = x + dx[i];
//			ny = y + dy[i];
//
//			if(check(nx, ny) && !visitedColor[nx][ny]) {
//				if(arr[nx][ny] == color) {
//					visitedColor[nx][ny] = true;
//					findAreaColor(nx, ny, color);		// 변화된 값으로 탐색(재귀)
//				}
//			}
//			
//		}
//		return;
//		
//	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 배열의 크기
		
		arr = new char[N][N];				// 입력받은 크기만큼 배열 생성
		visited = new boolean[N][N];		// 방문 배열
		//visitedColor = new boolean[N][N];	// 방문배열
		
		for(int i = 0; i < N; i++) {
			char[] chrArr = br.readLine().toCharArray();		// 배열에 입력받기
			arr[i] = chrArr;
		}
		
		int res = 0;
		int resColor = 0;
		
		// 색약 X
		for(int i = 0; i < N; i++) {	
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {			// 아직 방문 전
					visited[i][j] = true;		// 방문 확인 처리
					findArea(i, j, arr[i][j]);	// 해당 값으로 dfs 시작
					res++;	// 구역 1증가
				}
				
			}
		}
		
		// 색약이 보는 배열로 만들기(R과 G가 같은 색으로 보임 -> G를 R로 만들어주기)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 'G') {		
					arr[i][j] = 'R';
				}
			}
		}
		
		// 색약 O
		visited = new boolean[N][N];		// 방문 배열
		for(int i = 0; i < N; i++) {	
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {			// 아직 방문 전
					visited[i][j] = true;		// 방문 확인 처리
					findArea(i, j, arr[i][j]);	// 해당 값으로 dfs 시작
					resColor++;	// 구역 1증가
				}
				
			}
		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				if(!visitedColor[i][j]) {				// 아직 방문 전
//					visitedColor[i][j] = true;			// 방문 확인 처리
//					findAreaColor(i, j, arr[i][j]);		// 해당 값으로 dfs 시작
//					resColor++;			// 구역 1증가
//				}
//			}
//		}
		
		System.out.printf("%d %d", res, resColor);
	}

}
