import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int v;
		int w;
		
		public Point(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Point p) {
			return this.w - p.w;		// 오름차순 정렬
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Point>> list = new ArrayList<>();
		
		for(int i = 0; i <= V; i++) {
			list.add(new ArrayList<Point>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Point(v, w));
		}
		
		int [] result = bfs(list, V, K);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(result[i] == Integer.MAX_VALUE) sb.append("INF"+"\n");
			else sb.append(result[i]+"\n");
		}
		
		System.out.println(sb.toString());

	}
	
	static int [] bfs(ArrayList<ArrayList<Point>> list, int V, int K) {
		int [] arr = new int[V+1];
		Arrays.fill(arr,  Integer.MAX_VALUE);
		arr[K] = 0;
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(K, 0));
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(arr[p.v] < p.w) continue;	// 이미 최솟값
			
			for(int i = 0; i < list.get(p.v).size(); i++) {
				int curV = list.get(p.v).get(i).v;
				int curW = list.get(p.v).get(i).w;
				
				if(arr[curV] > p.w + curW) {
					arr[curV] = p.w + curW;
					pq.add(new Point(curV, arr[curV]));
				}
			}
		}
		
		return arr;
	}

}
