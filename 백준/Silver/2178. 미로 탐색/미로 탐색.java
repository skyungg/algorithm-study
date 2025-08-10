import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char [][] arr = new char[N][M];
		
		// 입력 받기
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		System.out.println(bfs(arr, N, M));
	
	}
	
	static int bfs(char [][] arr, int n, int m) {
		int result = 0;
		Queue<int []> que = new LinkedList<>();
		boolean [][] visited = new boolean[n][m];
		
		que.add(new int [] {0, 0, 1});		// 초기 위치 및 누적칸 수
		visited[0][0] = true;
		
		int [] dx = {-1, 0, 1, 0};
		int [] dy = {0, 1, 0, -1};
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(point[0] == n-1 && point[1] == m-1) {	// 목적지 도착
				result = point[2];
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(tx >= 0 && tx < n && ty >= 0 && ty < m) {
					if(!visited[tx][ty] && arr[tx][ty] == '1') {
						visited[tx][ty] = true;	// 방문처리
						que.add(new int[] {tx, ty, point[2]+1});
					}
				}
			}
		}
		
		return result;
	}
}
