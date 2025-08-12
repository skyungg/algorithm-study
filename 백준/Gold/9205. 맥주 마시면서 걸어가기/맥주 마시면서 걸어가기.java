import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			// 상근이 집 
			int [] home = new int[2];
			st = new StringTokenizer(br.readLine());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			// 편의점
			int [][] con = new int[n][2];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				con[i][0] = Integer.parseInt(st.nextToken());
				con[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 펜타포트
			st = new StringTokenizer(br.readLine());
			int pentaX = Integer.parseInt(st.nextToken());
			int pentay = Integer.parseInt(st.nextToken());
			
			boolean [] visited = new boolean[n];		// 편의점 방문배열
			Queue<int []> que = new LinkedList<>();
			que.add(new int[] {home[0], home[1]});
			boolean flag = false;
			
			while(!que.isEmpty()) {
				int [] point = que.poll();
				
				// 펜타와의 거리 측정
				if(cal(point[0], point[1], pentaX, pentay) <= 1000) {	// 현재 위치에서 바로 펜타 도착 가능
					sb.append("happy\n");
					flag = true;
					break;
				}
				
				for(int i = 0; i < n; i++) {
					if(!visited[i]) {
						if(cal(point[0], point[1], con[i][0], con[i][1]) <= 1000) {
							visited[i] = true;
							que.add(new int [] {con[i][0], con[i][1]});
						}
					}
				}
			}
			if(!flag) sb.append("sad\n");
		}
		
		System.out.print(sb.toString());
		
	}
	
	static int cal(int x, int y, int px, int py) {
		return Math.abs(x-px) + Math.abs(y-py);
	}

}
