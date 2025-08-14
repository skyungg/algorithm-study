import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t1 = Integer.parseInt(st.nextToken());
		int t2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		Queue<int []> que = new LinkedList<>();
		que.add(new int[] {t1, 0});		// 현재 번호, 촌수관계
		boolean [] visited = new boolean[n+1];
		visited[t1] = true;
		int result = -1;
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(point[0] == t2) {
				result = point[1];
				break;
			}
			
			List<Integer> list = graph.get(point[0]);
			
			for(int i = 0; i < list.size(); i++) {
				if(!visited[list.get(i)]) {
					visited[list.get(i)] = true;
					que.add(new int[] {list.get(i), point[1]+1});
				}
			}
		}
		
		System.out.println(result);
	}

}
