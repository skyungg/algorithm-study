import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	static List<int []> point = new ArrayList<>();
	static int [] dx = {-1, 1, 0, 0};		// 상하좌우
	static int [] dy = {0, 0, -1, 1};
	static int minTime = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) point.add(new int[] {i, j});		// 바이러스 퍼뜨릴 수 있는 위치
			}
		}
		
		if(point.size() <= M) {
			// 바로 바이러스 확산하기
			spread(point);
		}else {
			dfs(0, 0, new ArrayList<>());			
		}
		
		// 결과 출력
		if(minTime == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minTime);
	}
	
	static void dfs(int start, int cnt, List<int []> curList) {
		if(cnt == M) {
			// M개 위치 선정
			spread(curList);		// 바이러스 확산
			return;
		}
		
		for(int i = start; i < point.size(); i++) {
			curList.add(point.get(i));
			dfs(i+1, cnt+1, curList);
			curList.remove(curList.size() - 1);
		}
	}
	
	static void spread(List<int []> list) {
		Queue<int []> que = new LinkedList<>();
		boolean [][] visited = new boolean[N][N];
		
		// 미리 방문처리하기
		for(int [] li : list) {
			que.add(new int[] {li[0], li[1], 0});
			visited[li[0]][li[1]] = true;
		}
		
		int result = -1;
		
		while(!que.isEmpty()) {
			int [] p = que.poll();
			result = Math.max(result,  p[2]);
			
			for(int i = 0; i < 4; i++) {
				int tx = p[0] + dx[i];
				int ty = p[1] + dy[i];
				
				if(!checkRange(tx, ty)) continue;	// 범위 밖 -> 다음차례
				if(visited[tx][ty]) continue;	// 이미 방문 경우 -> 다음 차례
				if(map[tx][ty] != 1 ) {
					
					visited[tx][ty] = true;
					que.add(new int[] {tx, ty, p[2]+1});
				}

			}
		}
		
		// 확인하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] != 1) return;	// 벽도 아닌데, 퍼지지 못 한 경우 -> 더이상 어떻게 할 수 없음
			}
		}
		
		minTime = Math.min(minTime, result);
	}
	
	static boolean checkRange(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}
}
