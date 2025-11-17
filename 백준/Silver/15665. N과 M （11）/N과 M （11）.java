import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int [] result;
	static int [] nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(nums);
		
		dfs(0);
		
		// 정답 출력 
		System.out.println(sb);
		
	}
	
	static void dfs(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;	// 현재 cnt에서 같은 숫자 중복 방지용 변수
		for(int i = 0; i < N; i++) {
			if(prev == nums[i]) continue;
			
			result[cnt] = nums[i];
			prev = nums[i];
			dfs(cnt+1);
		}
	}

}
