import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int num;
		int w;
		
		public Point(int num, int w) {
			this.num = num;
			this.w = w;
		}
		
		@Override
		public int compareTo(Point p) {
			return this.w - p.w;	// 소의 수 오름차순 정렬
		}
	}
	
	static int n, m;
	static List<List<Point>> map = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n+1; i++) {
			map.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map.get(a).add(new Point(b, c));
			map.get(b).add(new Point(a, c));
		}
		
		// 다익스트라
		int answer = dijkstra();
		
		System.out.println(answer);
	}
	
	static int dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int minCount = Integer.MAX_VALUE;		// 최소 여물의 비용
		pq.add(new Point(1, 0));
		int [] minWeight = new int[n+1];
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			for(int i = 0; i < map.get(p.num).size(); i++) {
				Point curPoint = map.get(p.num).get(i);
				
				int curWeight =curPoint.w + p.w;
				if(curWeight < minWeight[curPoint.num]) {
					pq.add(new Point(curPoint.num, curWeight));
					minWeight[curPoint.num] = curWeight;
					
				}
			}			
		}
		
		return minWeight[n];
	}
}
