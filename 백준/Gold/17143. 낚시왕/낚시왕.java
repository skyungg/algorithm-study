import java.io.*;
import java.util.*;

/*아이디어: 구현
 * 1. 낚시왕 오른쪽 방향으로 한 칸 이동
 * 2. 이동한 위치에서 가장 가까운 상어 잡기 -> 현재 열 기준, 가장 가까운 행에 있는 상어 잡기
 * 3. 상어들 1초 이동하기
 * 	(1) 상어들 한 칸씩 이동하기
 *  (2) 상어 잡아 먹히는 유무 판단
 *  (3) 위의 과정 반복하면서 과정 반복하기
 * 4. 다시 1부터 시작
 * ---
 * map -> 상어 크기만 저장
 * que -> 현재 살아 있는 상어 정보만 저장
 * 
 * */
public class Main {
	static class Point{
		int x;
		int y;
		int s;
		int d;
		int z;
		
		public Point(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int R, C, M;
	static int [][] map;
	static int [] dx = {0, -1, 1, 0, 0};
	static int [] dy = {0, 0, 0, 1, -1};
	static List<int []> infoList = new ArrayList<>();
	
	static Queue<int []> que;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());	// 행
		C = Integer.parseInt(st.nextToken());	// 열
		M = Integer.parseInt(st.nextToken());	// 상어 수

		if (M == 0) {
		    System.out.println(0);
		    return;
		}
		
		map = new int[R+1][C+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());	// 행
			int c = Integer.parseInt(st.nextToken());	// 열
			int s = Integer.parseInt(st.nextToken());	// 속력
			int d = Integer.parseInt(st.nextToken());	// 이동 방향
			int z = Integer.parseInt(st.nextToken());	// 크기
		
			infoList.add(new int [] {r, c, s, d, z});
		}
		
		int col = 1;
		int result = 0;
		if(M > 0) {
			while(col <= C) {

				// 2. 현재 열기준, 가장 가까운 행에 위치한 상어 잡기
				int x = R+1;
				int idx = -1;	// 삭제할 index
				for(int i = 0; i < infoList.size(); i++) {
					int [] curList = infoList.get(i);
					if(curList[1] == col) {
						if(curList[0] < x) {
							x = curList[0];
							idx = i;
						}
					}
				}
				
				if(idx != -1) {
					result += infoList.get(idx)[4];
					infoList.remove(idx);		// 해당 상어 정보 infoList에서 삭제하기
				}
				
				// 3. 1초 동안 움직이기
				move();
				
				// 1. 낚시왕 오른쪽으로 움직이기
				col++;
			}
		}
		
		
		System.out.println(result);
	}
	
	static void move() {
		Point [][] newMap = new Point[R+1][C+1];
		List<int []> newList = new ArrayList<>();
		for(int i = 0; i < infoList.size(); i++) {
			int [] curInfo = infoList.get(i);		// 현재 상어
			
			int curX = curInfo[0];
			int curY = curInfo[1];
			int curS = curInfo[2];	// 속력
			int curD = curInfo[3];	// 방향
			int curZ = curInfo[4];	// 크기
			
			// 위치 검증 
			int oriS = curS;
			if (curD == 1 || curD == 2) curS %= (R - 1) * 2;
			else curS %= (C - 1) * 2;
			
			
			while (curS-- > 0) {
			    int nx = curX + dx[curD];
			    int ny = curY + dy[curD];

			    if (nx < 1 || nx > R || ny < 1 || ny > C) {
			        if (curD == 1) curD = 2;
			        else if (curD == 2) curD = 1;
			        else if (curD == 3) curD = 4;
			        else if (curD == 4) curD = 3;

			        nx = curX + dx[curD];
			        ny = curY + dy[curD];
			    }

			    curX = nx;
			    curY = ny;
			}
			
			if (newMap[curX][curY] == null || newMap[curX][curY].z < curZ) {
			    newMap[curX][curY] = new Point(curX, curY, oriS, curD, curZ);
			}
		}
		
		// 상어 정보 리스트 갱신하기
		infoList.clear();	// 초기화
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				if(newMap[i][j] != null) {
					infoList.add(new int [] {newMap[i][j].x, newMap[i][j].y, newMap[i][j].s, newMap[i][j].d, newMap[i][j].z });
				}
			}
		}
	}

}
