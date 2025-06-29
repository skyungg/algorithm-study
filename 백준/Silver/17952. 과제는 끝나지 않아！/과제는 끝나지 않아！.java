import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int score;
		int time;
		
		public Point(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Point> stack = new Stack<>();
		int totalScore = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			
			if(idx == 1) {
				int socre = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				stack.push(new Point(socre, time));
			}
			
			if(!stack.isEmpty()) {
				Point p = stack.peek();
				p.time--;
				
				if(p.time == 0) {
					totalScore += p.score;
					stack.pop();
				}
			}
		}
		
		System.out.println(totalScore);

	}

}
