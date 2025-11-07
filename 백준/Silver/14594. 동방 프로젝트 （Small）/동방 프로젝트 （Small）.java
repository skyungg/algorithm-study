import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean [] arr = new boolean[N];		// 벽 허물었는지 확인하기
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
				
			for(int idx = a; idx < b; idx++) {
				if(!arr[idx]) arr[idx] = true;	// 벽 허물기
			}
		}

		int cnt = 0;	
		
		for(int i = 1; i < N; i++) {
			if(!arr[i]) cnt++;		// 허물지 않음
		}
		
		System.out.println(cnt+1);
	}

}
