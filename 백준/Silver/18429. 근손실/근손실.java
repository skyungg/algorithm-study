/*
 * 아이디어 : 조합, dfs
 * 초기 : k보다 같거나 큰수 구해서 풀기 
 * 문제점 -> k보다 크거나 같은 수가 있어도, (k=4, n = {4, 3, 3} 이 경우를 못 거름)
 * -> 개선방향 : n의 최대 크기가 8이니까, 그냥 수열 돌리자!
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int k;
	static int [] arr;
	static int answer;		// 정답
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(500, new boolean[n], 0);
		
		// 정답 출력
		System.out.println(answer);
	}
	
	
	static void dfs(int w, boolean[] visited, int cnt) {
		if(cnt == n) {
			answer++;
			return;
		}
		
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				int newW = w + arr[i] - k;
				if(newW >= 500) {
					visited[i] = true;
					dfs(newW, visited, cnt+1);
					visited[i] = false;
				}
			}
		}

	}
}
