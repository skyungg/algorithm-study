import java.io.*;
import java.util.*;

/*
 * 아이디어: bfs
 * 힌트: 최솟값을 출력 -> bfs
 * 구: S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값을 출력
 * */
public class Main {
	static int F;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());	// 현재 위치
		int G = Integer.parseInt(st.nextToken());	// 도착 위치
		int [] steps = {Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken())};
		
		boolean [] visited = new boolean[F+1];
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {S, 0});	// 현재 위치, COUNT
		visited[S] = true;
		int result = Integer.MAX_VALUE;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			if(point[0] == G) {
				result = point[1];
				break;
			}
			
			// 조작하기
			for(int i = 0; i < 2; i++) {
				int s = point[0] + steps[i];
				if(!checkRange(s)) continue;
				if(visited[s]) continue;
				
				visited[s] = true;
				que.add(new int[] {s, point[1]+1});
			}
		}
		
		// 출력
		if(result == Integer.MAX_VALUE)System.out.println("use the stairs");
		else System.out.println(result);
		
	}
	
	static boolean checkRange(int cur) {
		return cur >= 1 && cur <= F;
	}

}
