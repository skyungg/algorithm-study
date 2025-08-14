import java.io.*;
import java.util.*;

public class Main {
	static int n, m, h;
	static int [][][] map;
	static Queue<int []> que = new LinkedList<>();
	static int rest_cnt = 0;	// 익지 않은 토마토 수
	static int [] dh = {1, -1, 0, 0, 0, 0};
	static int [] dx = {0, 0, -1, 0, 1, 0};
	static int [] dy = {0, 0, 0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][n][m];	
		
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if(map[k][i][j] == 1) {
						que.add(new int [] {k, i, j, 0});	// 익은 토마토 que에 삽입
					}else if(map[k][i][j] == 0) rest_cnt++;		// 익지 않은 토마토 수
				}
			}
		}
		
		if(rest_cnt == 0) System.out.println(0);
		else {
			// 후숙처리하기
			System.out.println(bfs());
			}
	}
	
	static int bfs() {
		int time = 0;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(rest_cnt == 0)break;
			
			for(int i = 0; i < 6; i++) {
				int th = point[0] + dh[i];
				int tx = point[1] + dx[i];
				int ty = point[2] + dy[i];
				
				if(checkRange(th, tx, ty) && map[th][tx][ty] == 0) {
					map[th][tx][ty] = 1;
					que.add(new int[] {th, tx, ty, point[3]+1});
					time = Math.max(time, point[3]+1);
					rest_cnt--;
				}
			}
		}
		
		if(rest_cnt > 0) time = -1;
		
		return time;
	}
	
	static boolean checkRange(int th, int tx, int ty) {
		return th >= 0 && th < h && tx >= 0 && tx < n && ty >= 0 && ty < m;
	}
}
