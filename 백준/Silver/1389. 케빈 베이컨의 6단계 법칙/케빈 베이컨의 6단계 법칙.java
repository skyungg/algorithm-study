import java.io.*;
import java.util.*;

/*
 * 아이디어: 완탐
 * (1) 블록제거 -> 2초
 * (2) inventory에서 가져오기 -> 1초
 * */

public class Main {
	static int N, M;
	static int [][] adj;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		// 유저 수
		M = Integer.parseInt(st.nextToken());		// 친구 관계 수
		
		adj = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	
			int b = Integer.parseInt(st.nextToken());	
			
			adj[a][b] = 1;		// 친구 관계
			adj[b][a] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			bfs(i);
		}
		
		// 베이컨 계산
		int minCount = Integer.MAX_VALUE;
		int resNum = 0;
		for(int i = 1; i <= N; i++) {
			int [] dist = bfs(i);
			int sum = 0;
			
			for(int j = 1; j <= N; j++) {
				sum += dist[j];
			}
			
			if(sum < minCount) {	// 갱신하기
				minCount = sum;
				resNum = i;
			}
		}
		
		System.out.println(resNum);
	}
	
	static int [] bfs(int start) {
		boolean [] visited = new boolean[N+1];
		int [] dist = new int[N+1];
		Queue<Integer> que = new LinkedList<>();
		
		que.add(start);
		visited[start] = true;		
		
		while(!que.isEmpty()) {
			int target = que.poll();
			
			for(int i = 1; i <= N; i++) {
				if(adj[target][i] == 1 && !visited[i]) {	// 친구관계이면서 아직 방문 안함.
					visited[i] = true;
					dist[i] = dist[target]+1;
					que.add(i);
				}
			}
		}
		
		return dist;
	}

}
