import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
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
		
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(nums);
		
		dfs(0, 0);
		
		// 출력
		System.out.println(sb);
		
	}
	
	static void dfs(int cnt, int idx) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		int preNum = -1;	// 현재 cnt에서 중복 방지용
		for(int i = idx; i < N; i++) {
			if(visited[i]) continue;
			if(preNum == nums[i]) continue;
			
			visited[i] = true;
			result[cnt] = nums[i];
			preNum = nums[i];
			
			dfs(cnt+1, i+1);
			
			visited[i] = false;
 		}
	}

}
