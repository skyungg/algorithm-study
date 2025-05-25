import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int x;
		int y;
		int num;
		
		public Point(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	static int n, m;
	static int minValue = Integer.MAX_VALUE;
	static int [][] map;
	static List<Point> list = new ArrayList<>();
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, -1, 0, 1};
	static List<List<List<Integer>>> direction = Arrays.asList(
	        Arrays.asList(Arrays.asList(0), Arrays.asList(1), Arrays.asList(2), Arrays.asList(3)),
	        Arrays.asList(Arrays.asList(0, 2), Arrays.asList(1, 3)),
	        Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(2, 3)),
	        Arrays.asList(Arrays.asList(0, 1, 3), Arrays.asList(1, 2, 3), Arrays.asList(0, 1, 2), Arrays.asList(0, 2, 3)),
	        Arrays.asList(Arrays.asList(0, 1, 2, 3))
	    );
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		boolean [][] visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) {
					list.add(new Point(i, j, map[i][j]));	// cctv 위치, 종류 저장
				}
				if(map[i][j] != 0) visited[i][j] = true;	// 방문 처리
			}
		}
		
		start(0, visited);
		
		System.out.println(minValue);
	}
	
	/*
	 * cnt: cctv 위치
	 * */
	static void start(int cnt, boolean [][] visited) {
		if(cnt == list.size()) {
			minValue = Math.min(minValue,  getMinSpace(visited));
			return;
		}
		
		Point p = list.get(cnt);
		List<List<Integer>> dirs = direction.get(p.num-1);
		
		int num = p.num;	// 0부터 시작하니까
		for(int i = 0; i < dirs.size(); i++) {
			boolean [][] curVisited = new boolean[n][m];	// 현재 방문 배열 생성
			for (int q = 0; q < n; q++) {
				curVisited[q] = visited[q].clone(); 		// 각 행을 clone()으로 복사 -> 깊은 복사
			}
			
			List<Integer> dirSet = dirs.get(i);
			for(int j = 0; j < dirSet.size(); j++) {
				int dir = dirSet.get(j);
				watch(p.x, p.y, dir, curVisited);
			}
			start(cnt+1, curVisited);
		}
	}
	
	static void watch(int x, int y, int dir, boolean [][] curVisited) {
		while (true) {
            x += dx[dir];
            y += dy[dir];

            if (!checkRange(x, y) || map[x][y] == 6) break;		// 아직 방문전, 벽이 아닌 경우
            curVisited[x][y] = true;
        }
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	static int getMinSpace(boolean [][] visited) {
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j]) answer++;
			}
		}
		
		return answer;
	}

}
