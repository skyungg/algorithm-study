import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int num;
		String path;
		
		public Point(int num, String path) {
			this.num = num;
			this.path = path;
		}
	}
	static boolean [] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			sb.append(start(A, B)+"\n");
		}
		
		// 정답 출력
		System.out.println(sb.toString());

	}
	
	static String start(int curNum, int target) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(curNum, ""));
		String result = "";
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			if(p.num == target) {
				result = p.path;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				if(i == 0) {
					if(!visited[(2*p.num)%10000]) {
						visited[(2*p.num)%10000] = true;
						que.add(new Point((2*p.num)%10000, p.path+"D"));							
					}
				}else if(i == 1) {
					if(p.num == 0) {
						if(!visited[9999]) {
							visited[9999] = true;
							que.add(new Point(9999, p.path+"S"));
						}
					}
					else if(!visited[p.num-1]) {
						visited[p.num-1] = true;
						que.add(new Point(p.num-1, p.path+"S"));
					}
				}else if(i == 2) {
					int dNum = (p.num%1000)*10 + (p.num/1000);
					
					if(!visited[dNum]) {
						visited[dNum] = true;
						que.add(new Point(dNum, p.path+"L"));
					}
				}else {
					int dNum = (p.num%10)*1000+(p.num/10);
					
					if(!visited[dNum]) {
						visited[dNum] = true;
						que.add(new Point(dNum, p.path+"R"));
					}
				}
			}

		}
		
		return result;
		
	}

}
