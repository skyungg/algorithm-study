import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int count = 0;		// 안 익은 토마토 개수
	static Queue<int []> que = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) count++;
				if(map[i][j] == 1) que.add(new int[] {i, j, 0});
			}
		}
		
		// 정답 출력
		
		if(count == 0) System.out.println(0);
		else System.out.println(bfs());
		
	}
	
	static int bfs() {
		int result = 0;
		while(!que.isEmpty()) {
			if(count == 0) break;
			
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(!checkRange(tx, ty)) continue;
				if(map[tx][ty] == 0 && !visited[tx][ty]) {
					visited[tx][ty] = true;
					result = Math.max(result, point[2]+1);
					que.add(new int [] {tx, ty, point[2]+1});
					count--;
				}
			}
		}
		
		if(count > 0) return -1;
		else return result;
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
