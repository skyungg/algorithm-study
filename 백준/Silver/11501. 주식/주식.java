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
			int target = arr[n-1];		// 기준값
			long cost = 0;		// 총 수익금
			
			
			for(int i = n-2; i >= 0; i--) {
				if(target > arr[i]) {
					cost += target - arr[i];
				}else {
					target = arr[i];
				}
			}
			
			sb.append(cost+"\n");
		}
		
		System.out.println(sb.toString());
		
	}

}
