import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int [][] map;
	static int [] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int [] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int [] diaX = {-1, -1, 1, 1};
	static int [] diaY = {-1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][] op = new int[m][2];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			op[i][0] = Integer.parseInt(st.nextToken());
			op[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 구름 초기 위치
		List<int[]> clouds = new ArrayList<>();
        clouds.add(new int[]{n - 1, 0});
        clouds.add(new int[]{n - 1, 1});
        clouds.add(new int[]{n - 2, 0});
        clouds.add(new int[]{n - 2, 1});
		
		// 이동 하기
		for(int i = 0; i < m; i++) {
			int di = op[i][0];		// 방향
			int si = op[i][1];		// 칸 이동수
			
			
			// 1. 구름 이동
			List<int[]> movedClouds = new ArrayList<>();		// 이동한 구름 위치
            for (int[] c : clouds) {
                int x = (c[0] + dx[di] * si % n + n * 100) % n;
                int y = (c[1] + dy[di] * si % n + n * 100) % n;
                map[x][y]++;
                movedClouds.add(new int[]{x, y});
            }
			
			// 2. 물복사
			for (int[] c : movedClouds) {
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = c[0] + diaX[j];
                    int ny = c[1] + diaY[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] > 0) {
                        count++;
                    }
                }
                map[c[0]][c[1]] += count;
            }
			
			// 3. 구름 생성
			List<int[]> newClouds = new ArrayList<>();
            boolean[][] visited = new boolean[n][n];
            for (int[] c : movedClouds) {
            	visited[c[0]][c[1]] = true;		// 현재 구름 위치 확인
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (!visited[r][c] && map[r][c] >= 2) {
                        map[r][c] -= 2;
                        newClouds.add(new int[]{r, c});
                    }
                }
            }
            clouds = newClouds;	// 구름 갱신

			
		}
		
		// 정답 출력
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				answer += map[i][j];
			}
		}
		
		System.out.println(answer);
		
		

	}
	
}
