import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {N, 0});		// 현재 위치, 시간
		boolean [] visited = new boolean[100001];
		visited[N] = true;
		int result = 0;
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(point[0] == K) {
				result = point[1];
				break;
			}
			
			// 계산
			int ax = point[0]+1;
			int bx = point[0]-1;
			int cx = point[0]*2;
			
			if(ax >= 0 && ax <= 100000 && !visited[ax]) {
				que.add(new int[] {ax, point[1]+1});
				visited[ax] = true;
			}
			if(bx >= 0 && bx <= 100000&& !visited[bx]) {
				que.add(new int[] {bx, point[1]+1});
				visited[bx] = true;
			}
			if(cx >= 0 && cx <= 100000&& !visited[cx]) {
				que.add(new int[] {cx, point[1]+1});
				visited[cx] = true;
			}
			
		}
		
		System.out.println(result);
	}

}
