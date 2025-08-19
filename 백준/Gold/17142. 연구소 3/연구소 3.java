import java.io.*;
import java.util.*;

/*
 * 아이디어: 조합, 그래프탐색
 * ---
 * [초기]
 * 1인 위치 중에 m개 활성화해서, 최댓값 찾기
 * -> 2인 위치로 수정
 * -----
 * 0은 빈 칸, 1은 벽, 2는 비활성 바이러스의 위치
 * */
public class Main {
	static int N, M;
	static int [][] map;
	static List<int []> list = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	static int count = 0;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) list.add(new int[] {i, j, 0});
				if(map[i][j] == 0) count++;
			}
		}
		if(count == 0) {
			System.out.println(0);
			return;
		}
		
		// 조합 만들기
		combinate(0, 0, new int[M]);

		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	static void combinate(int cnt, int start, int [] arr) {
		if(cnt == M) {
			Queue<int []> que = new LinkedList<>();
			boolean [][] visited = new boolean[N][N];
			for(int idx : arr) {
				int [] target = list.get(idx);
				que.add(new int[] {target[0], target[1], 0});
				visited[target[0]][target[1]] = true;
			}
			bfs(que, visited);
			return;
		}
		
		for(int i = start; i < list.size(); i++) {
			arr[cnt] = i;
			combinate(cnt+1, i+1, arr);
		}
	}
	
	static void bfs(Queue<int []> que, boolean [][] visited) {
		int time = 0;
		int cnt = 0;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(checkRange(tx, ty) && !visited[tx][ty] && map[tx][ty] != 1) {
					visited[tx][ty] = true;
					que.add(new int[] {tx, ty, point[2]+1});
					if(map[tx][ty] == 0) {
						cnt++;
						time = Math.max(time,  point[2]+1);
						if(cnt == count) {		// 빈 곳 모두 감염
							result = Math.min(result, time);
							return;
						}
					}
				}
			}
		}
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
