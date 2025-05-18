import java.io.*;
import java.util.*;

/*
 * 아이디어: 뒤에서부터 판별
 * */

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 구현
			int idx = n-1;
			int target = arr[idx];		// 기준값
			boolean [] visited = new boolean[n];
			long total_budget = 0;		// 총 수익금
			
			while(idx > 0) {			
				for(int i = idx-1; i >= 0; i--) {
					if(!visited[i]) {
						if(target > arr[i]) {	// 아직 방문 전 + target이 더 큰경우
							total_budget += target - arr[i];	// 수익금
							visited[i] = true;
						}else break;
					}else break;
					
				}
				idx--;
				target = arr[idx];
			}
			
			sb.append(total_budget+"\n");
		}
		
		System.out.println(sb.toString());
		
	}

}
