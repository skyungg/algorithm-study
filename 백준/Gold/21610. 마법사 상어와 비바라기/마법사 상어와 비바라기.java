import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 격자 크기
		int M = Integer.parseInt(st.nextToken());	// 이동횟수
		
		int [][] arr = new int[N][N];	// 입력받은 크기만큼 2차원 배열 생성
		
		for(int i = 0; i < N; i++) {		// 바구니 정보 입력받기
			st= new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][] moveInfo = new int[M][2];	// 구름 이동 정보
		for(int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			moveInfo[i][0] = Integer.parseInt(st.nextToken())-1;	// 방향 정보(인덱스 0부터 시작)
			moveInfo[i][1] = Integer.parseInt(st.nextToken());	// 거리 정보
		}
		
		int[][] direction = {{0,-1}, {-1,-1}, {-1,0},{-1,1}, 
				{0,1}, {1,1}, {1,0}, {1,-1}};	// 이동방향 di
		int[][] diagonal = {{-1,-1}, {-1,1}, {1,1}, {1,-1}};	// 대각선 
		
		Queue<int []> que = new LinkedList<int []>();	// 생성한 구름 저장
		
		// 1. 초기 구름 생성 하기 -> 생성한 구름은 que에 저장
		int [][] init = {{N-2, 0}, {N-2, 1}, {N-1, 0}, {N-1, 1}};	// 초기 구름 생성 위치
		for(int i = 0; i < 4; i++) {
			que.offer(new int[] {init[i][0], init[i][1]});	// 초기 구름 생성 위치를 que에 저장
		}
		
		// 2. 구름 M번 이동
		for(int m = 0; m < M; m++) {
			boolean [][] visited = new boolean[N][N];	// 구글 생성 여부 확인 방문 배열
			// 2.1 모든 구름 이동시키기
			int msize = que.size();
			for(int i = 0; i < msize; i++) {
				int [] tmp = que.poll();
				// 저장된 구름 위치 + 방향*거리
				int nr = tmp[0] + direction[moveInfo[m][0]][0] * moveInfo[m][1];
				int nc = tmp[1] + direction[moveInfo[m][0]][1] * moveInfo[m][1];
				
				// 0행과 N-1행은 연결되어 있음!!!
				if(nr < 0) {		// 0 미만
					nr = (nr + N*50) % N;
				}else if(nr >= N) {		// N 이상
					nr = nr % N;
				}
				
				if(nc < 0) {		// 0 미만
					nc = (nc + N*50) % N;
				}else if(nc >= N) {		// N 이상
					nc = nc % N;
				}
				
				que.offer(new int[] {nr, nc});	// 이동한 구름 좌표 추가
				// 2.2  이동한 구름의 칸의 물 1 증가
				arr[nr][nc]++;
				
			}
			// 2.3 물복사버그 시전 -> 대각선 방향 물 증가
			int dsize= que.size();
			for(int i = 0; i < dsize; i++) {
				int [] tmp = que.poll();
				int r = tmp[0];
				int c = tmp[1];
				
				visited[r][c] = true;	// 구름 사라진 위치 표시 하기 -> 조건 5
				int count = 0;	// 거리가 1인 대각선 방향에 물이 있는 바구니의 수
				
				// 대각선 정보
				for(int idx = 0; idx < 4; idx++) {
					int nr = r + diagonal[idx][0];
					int nc = c + diagonal[idx][1];
					
					if( nr >= 0 && nr < N && nc >= 0 && nc < N 
							&& arr[nr][nc] > 0) {
						// 대각선이 범위 내에 위치 + 해당 대각선의 물의 양이 있을 경우
						count++;
					}
				}
				arr[r][c] += count;	// 물이 있는 대각선의 수만큼 물양 증가
			}
			
			// 2.4 구름 생성(바구니에 물이 2 이상인 칸)
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] >= 2 && !visited[i][j]) {
						// 해당 칸의 물의 양이 2 이상 + 이전에 구름 생성한 적이 없어야됨
						que.offer(new int[] {i, j});	// 구름 생성위치 저장
						arr[i][j] -= 2;	// 물의 양 2 감소
					}
				}
			}
		}
		
		// 결과 출력 : 모든 바구니에 들어있는 물의 양의 합
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				result += arr[i][j];
			}
		}
		System.out.println(result);
	}
}
