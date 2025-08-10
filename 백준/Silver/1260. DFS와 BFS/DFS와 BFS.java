import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> list = new ArrayList<>();	// 인접 리스트
	static boolean[] dVisited;
	static List<Integer> dResult = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 정점 개수
		int M = Integer.parseInt(st.nextToken());	// 간선 개수
		int V = Integer.parseInt(st.nextToken());	// 시작정점
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		// 입력 
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());	
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		// 정렬
		for(int i = 1; i <= N; i++) {
			if(!list.get(i).isEmpty()) {
				// 오름차순 정렬
				Collections.sort(list.get(i));
			}
		}
		
		// dfs 돌리기
		dVisited = new boolean[N+1];
		dfs(V);
		
		// bfs 돌리기
		List<Integer> bfsResult = bfs(N, V);
		
		StringBuilder sb = new StringBuilder();
		for(int num : dResult) {
			sb.append(num+" ");
		}
		sb.append("\n");
		for(int num : bfsResult) {
			sb.append(num+" ");
		}
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int start) {
		dVisited[start] = true;
		dResult.add(start);
		
		for(int i = 0; i < list.get(start).size(); i++) {
			if(!dVisited[list.get(start).get(i)]) {
				dfs(list.get(start).get(i));
			}
		}
		
		return;
		
	}
	
	static List<Integer> bfs(int N, int start) {
		Queue<Integer> que = new LinkedList<>();
		boolean [] visited = new boolean[N+1];
		List<Integer> result = new ArrayList<>();
		
		// 시작 정점 처리
		visited[start] = true;
		result.add(start);
		que.add(start);
		
		while(!que.isEmpty()) {
			int num = que.poll();
			
			List<Integer> curList = list.get(num);
			
			for(int i = 0; i < curList.size(); i++) {
				if(visited[curList.get(i)]) continue;	// 이미 방문
				
				result.add(curList.get(i));
				visited[curList.get(i)] = true;
				que.add(curList.get(i));
			}
		}
		
		// 결과 반환
		return result;
	}
}



