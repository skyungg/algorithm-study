import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int idx;
		int g;
		int s;
		int b;
		
		public Point(int idx, int g, int s, int b) {
			this.idx = idx;
			this.g = g;
			this.s = s;
			this.b = b;
		}
		
		@Override
		public int compareTo(Point p) {
			if(this.g == p.g) {
				if(this.s == p.s) {
					return p.b - this.b;
				}else {
					return p.s - this.s;
				}
			}else {
				return p.g - this.g;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Point> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.add(new Point(idx, g, s, b));
		}
		
		Collections.sort(list);
		
		int rank = 1;
		int sameRank = 1;
		Point pre = list.get(0);	// 첫 번째

		for(int i = 0; i < list.size(); i++) {
			Point cur = list.get(i);
			if(i > 0 && (pre.g != cur.g || pre.s != cur.s || pre.b != cur.b)) {
				rank += sameRank;	// 공동 순위 반영
				sameRank = 1;		// 공동 순위 초기화
			}else if(i > 0) {
				sameRank++;
			}
			
			if(cur.idx == k) {
				System.out.println(rank);
				break;
			}
			
			pre = cur;
		}
		
		
	}

}
