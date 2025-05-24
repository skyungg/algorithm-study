import java.io.*;
import java.util.*;

public class Main {
	static int [] dx = {0, 0, 0, -1, 1};
	static int [] dy = {0, 1, -1, 0, 0};
	static int [][] dice = new int[4][3];		// 주사위 초기 위치
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		String [] op = br.readLine().split(" ");
		
		for(int i = 0; i < k ; i++) {
			int dir = Integer.parseInt(op[i]);		// 구르는 방향
			
			// 1. 위치 이동하기
			int tx = x + dx[dir];
			int ty = y + dy[dir];
			
			if(tx < 0 || tx >=n || ty < 0 || ty >= m) continue;	// 범위 밖 -> 무사하기
			
			// 2. 주사위 굴리기
			if(dir == 1) {
				int tmp = dice[1][2];
				for(int j = 2; j > 0; j--) {
					dice[1][j] = dice[1][j-1];
				}
				dice[1][0] = dice[3][1];
				dice[3][1] = tmp;
				
			}else if(dir == 2) {
				int tmp = dice[1][0];
				for(int j = 0; j < 2; j++) {
					dice[1][j] = dice[1][j+1];
				}
				dice[1][2] = dice[3][1];
				dice[3][1] = tmp;
				
			}else if(dir == 3) {						// 북, 남 이동 -> 1행 고정, 1열만 dir에 따라 이동
				int tmp = dice[0][1];
				for(int j = 0; j < 3; j++) {
					dice[j][1] = dice[j+1][1];
				}
				dice[3][1] = tmp;
			}else {
				int tmp = dice[3][1];
				for(int j = 3; j > 0; j--) {
					dice[j][1] = dice[j-1][1];
				}
				dice[0][1] = tmp;
			}
			
			// 3. 판별하기
			if(map[tx][ty] == 0) {
				map[tx][ty] = dice[3][1];	// 바닥면 복사
			}else {
				dice[3][1] = map[tx][ty];
				map[tx][ty] = 0;
 			}
			
			x = tx;		// 위치 갱신
			y = ty;
	
			// 결과
			sb.append(dice[1][1]+"\n");		// 맨 윗칸 출력
		}
		
		// 결과 출력
		System.out.println(sb.toString());
		
	}

}
