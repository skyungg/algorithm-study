import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int cur;
		int time;
		
		public Point(int cur, int time) {
			this.cur = cur;
			this.time = time;
		}
		
		@Override
		public int compareTo(Point p) {
			return this.time - p.time;
		}
	}
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());		// 수빈이 위치
		int k = Integer.parseInt(st.nextToken());		// 동생 위치
		
		if(n == k) {
			System.out.println(0);
			return;
		}
		
		boolean [] visited = new boolean[100001];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(n, 0));
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(p.cur == k) {
				System.out.println(p.time);
				break;
			}
			
			int a = p.cur-1;
			int b = p.cur+1;
			int c = p.cur*2;
			
			if(checkRange(a)) {
				if(!visited[a]) {
					visited[a] = true;
					pq.add(new Point(a, p.time+1));
				}
			}
			if(checkRange(b)) {
				if(!visited[b]) {
					visited[b] = true;
					pq.add(new Point(b, p.time+1));
				}
			}
			if(checkRange(c)) {
				if(!visited[c]) {
					visited[c] = true;
					pq.add(new Point(c, p.time+1));
				}
			}
		}
	}
	
	static boolean checkRange(int num) {
		if(num < 0 || num > 100000) return false;
		return true;
	}

}
