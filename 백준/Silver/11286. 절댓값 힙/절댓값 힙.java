import java.io.*;
import java.util.*;


public class Main {
	private static class Point implements Comparable<Point>{
		int abs;
		int num;
		
		public Point(int abs, int num) {
			this.abs = abs;
			this.num = num;
		}
		
		@Override
		public int compareTo(Point p) {
			if(this.abs == p.abs) return this.num - p.num;
			return this.abs - p.abs;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int current = Integer.parseInt(br.readLine());
			
			if(current == 0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll().num+"\n");
				}else {
					sb.append(0+"\n");
				}
			}else {
				pq.add(new Point(Math.abs(current), current));
			}
		}
		
		System.out.println(sb.toString());
	}

}
