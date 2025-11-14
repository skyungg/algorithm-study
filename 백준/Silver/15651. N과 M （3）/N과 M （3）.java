import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dfs(0, new int[M]);
		
		// 정답 출력
		System.out.println(sb);
	}
	
	static void dfs(int cnt,  int [] arr) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[cnt] = i;
			dfs(cnt+1, arr);
		}
	}

}
