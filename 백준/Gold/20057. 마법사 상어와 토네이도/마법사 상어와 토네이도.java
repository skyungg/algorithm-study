import java.io.*;
import java.util.*;

/*
 * 아이디어: 구현
 * 1. 토네이도 이동하기
 * 2. 모래 분배하기
 * [헷갈린 점] 
 * 1. 모래 뿌릴 때, 진행 방향만 뿌리는게 아니라 나와 있는 방향 다 뿌리는 거임
 * */
public class Main {
	static int N;
	static int [][] map;
	static int [] dx = {0, 1, 0, -1};	// 서, 남, 동, 북
	static int [] dy = {-1, 0, 1, 0};
	static int [] ratio = {1, 1, 7, 7, 10, 10, 2, 2, 5};		// 모래 비율
	// 방향 별, ratio 위치
	static final int[][] sprX = {
			{-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
	        {0, 0, 1, 1, 2, 2, 1, 1, 3, 2},
	        {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
	        {0, 0, -1, -1, -2, -2, -1, -1, -3, -2}
	};
	static final int[][] sprY = {
			{0, 0, -1, -1, -2, -2, -1, -1, -3, -2},
	        {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
	        {0, 0, 1, 1, 2, 2, 1, 1, 3, 2},
	        {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0}
	};
	static int result = 0;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		simulate();
		// 결과 출력
		System.out.println(result);
	}
	
	static void simulate() {
		int x = N/2;	// 시작점 (좌표 한 가운데)
		int y = N/2;
		
		int move_cnt = 1;
		int dir = 0;	// 이동 방향(초기에는 왼쪽)
		
		while(true) {
			for(int i = 0; i < 2; i++) {	// 같은 양으로 두번 이동하니까
				for(int j = 0; j < move_cnt; j++) {			// 이동 길이
					spread(x, y, dir);	// 모래 뿌리기
					x += dx[dir];	// 다음 칸으로 이동
					y += dy[dir];	
				}
				
				// 방향 전환하기
				dir = (dir+1)%4;
			}
			
			move_cnt++;
			
			if(move_cnt == N) {	// 마지막
				for(int i = 0; i < move_cnt-1; i++) {
					spread(x, y, dir);
					x += dx[dir];
					y += dy[dir];
				}
				return;
			}
		}
	}
	
	static void spread(int x, int y, int dir) {
		int tx = x + dx[dir];
		int ty = y + dy[dir];
		int cur_amount = map[tx][ty];	// 이동한 칸의 현재 모래양
		
		// 현재 위치 및 방향 기준으로 9방향으로 모래 날리기
		for(int i = 0; i < 9; i++) {
			int sx = x + sprX[dir][i];	
			int sy = y + sprY[dir][i];
			
			int add_send = cur_amount*ratio[i]/100;	// 현재 위치에 추가되는 양
			
			if(checkRange(sx, sy)) result += add_send;	// 격자 밖으로 나간 모래 누적
			else map[sx][sy] += add_send;	//범위 내 -> 해당 위치에 누적
			
			map[tx][ty] -= add_send;	// 날린 모래양 해당 위치에서 차감
		}
		
		// a로 이동 하기
		int ax = x + sprX[dir][9];	// a위치 잡기
		int ay = y + sprY[dir][9];
		
		if(checkRange(ax, ay)) result += map[tx][ty];
		else map[ax][ay] += map[tx][ty];;	
		
		map[tx][ty] = 0;	
		
	}
	
	static boolean checkRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}
