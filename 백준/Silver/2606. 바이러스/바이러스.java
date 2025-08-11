import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		System.out.println(bfs(graph, N));
		
	}
	
	static int bfs(List<List<Integer>> graph, int n) {
		Queue<Integer> que = new LinkedList<>();
		boolean [] visited = new boolean[n+1];
		que.add(1);	// 1부터 시작
		visited[1] = true;
		
		int result = 0;
		
		while(!que.isEmpty()) {
			int target = que.poll();
			
			if(graph.get(target).size() > 0) {
				List<Integer> tmpGraph = graph.get(target);
				for(int i = 0; i < tmpGraph.size(); i++) {
					int num = tmpGraph.get(i);
					if(!visited[num]) {
						visited[num] = true;
						que.add(num);
						result++;
					}
				}
			}
		}
		
		return result;
		
	}
}
