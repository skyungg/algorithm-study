import java.io.*;
import java.util.*;

public class Main {
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
		Queue<int []> que = new LinkedList<>();
		que.add(new int[] {n, 0});
		
		while(!que.isEmpty()) {
			int [] p = que.poll();
			int point = p[0];
			int time = p[1];
			
			if(point == k) {
				System.out.println(time);
				return;
			}
			
			int [] nextPoints = {point-1, point+1, point*2};
			
			for(int next : nextPoints) {
				if(next >= 0 && next <= 100000 && !visited[next]) {
					visited[next] = true;
					que.add(new int[] {next, time+1});
				}
			}
		}
	}

}
