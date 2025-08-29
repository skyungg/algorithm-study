import java.io.*;
import java.util.*;

/*
 * 아이디어: 구현, 그래프
 * 1. 현재 칸 청소 X -> 현재 칸 청소하기 (청소 구역 수 1증가)
 * 2. 현재 칸 기준 주변 4칸 중 청소 안 된 빈 칸 존재 X
	(1) 바라보는 방향 유지 + 한 칸 후진 가능 -> 후진하기 -> 1번으로 돌아가기(계속 청소하고 또 사방탐색)
	(2) 바라보는 방향 유지 + 한 칸 후진 불가능 (벽) -> 작동 멈춤(여기서 결과 산출)
   3. 현재 칸 기준 주변 4칸 중 청소 안 된 빈 칸 존재 O
	(1) 반시계 방향으로 90도 회전
	(2) 회전한 방향기준 앞 칸이 빈칸 -> 해당 칸으로 이동
   [포인트] 방향전환
 * [info]
 * 1. 0: 청소할 곳(이동 O), 1: 벽(이동 X), -1: 이미 청소한 곳(이동 o)
 * 
 * */

public class Main {
	static int N, M;
	static int [][] map;
	static int [] dx = {-1, 0, 1, 0};	// 북, 동, 남, 서
	static int [] dy = {0, 1, 0, -1};
	static int count = 0;		// 청소한 구역 수
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int cur_x = Integer.parseInt(st.nextToken());		// 시작 위치 및 방향
		int cur_y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		map[cur_x][cur_y] = -1;		// 청소는 완료, 벽은 아니니 이동은 가능 
		count++;
		
		clean(cur_x, cur_y, d);		
		
		
		// 정답 출력
		System.out.println(count);
		

	}
	
	static void clean(int x, int y, int d) {
		boolean flag = true;	// 현재 위치 인접 4방향 빈칸 존재
		
		for(int i = 0; i < 4; i++) {
			d = (d+3) % 4;	// 반시계방향으로 90도 회전
			
			int tx = x + dx[d];	
			int ty = y + dy[d];
			
			if(checkRange(tx, ty) && map[tx][ty] == 0) {	// 범위 내 위치 + 아직 청소 전
				map[tx][ty] = -1;	// 방문 처리
				flag = false;
				count++;
				clean(tx, ty, d);
				return;
			}
		}
		
		if(flag) {
			// 인접한 4방향 모두 이동 불가
			int back_dir = (d+2) % 4;	// 위치만 후진할 뿐, 방향은 현재 바라보는 방향 그대로임 -> 덮어쓰기X
			int back_x = x + dx[back_dir];
			int back_y = y + dy[back_dir];
			
			if(checkRange(back_x, back_y) && map[back_x][back_y] != 1) clean(back_x, back_y, d);
			else return;	// 더이상 진행X
		}
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
