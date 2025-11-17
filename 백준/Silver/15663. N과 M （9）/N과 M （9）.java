import java.io.*;
import java.util.*;

/*
 * N 개의 자연수에 중복이 포함되어 있음.
 * -> 중복된 자연수 집합에서 m개의 순열 구하기
 * 
 * */
public class Main {
	static int N, M;
	static Set<Integer> set = new HashSet<>();
	static int [] nums;
	static int [] result;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = (Integer.parseInt(st.nextToken()));
		}
		
		// 정렬
		Arrays.sort(nums);
		
		result = new int[M];
		visited = new boolean[N];
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	static void dfs(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) sb.append(result[i]+" ");
			sb.append("\n");
			return;
		}
		
		// 현재 cnt에서 해당 숫자 중복 체크용 방문 확인 배열
		boolean [] depth_visited = new boolean[10001];
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			// 같은 cnt에서 같은 숫자 중복 X
			if(depth_visited[nums[i]]) continue;
			depth_visited[nums[i]] = true;
			
			visited[i] = true;
			result[cnt] = nums[i];
			dfs(cnt+1);
			visited[i] = false;
		}
	}

}
