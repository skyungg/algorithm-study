import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long [] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		long end = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			end = Math.max(end,  arr[i]);
		}
		
		// 이분 탐색
		long start = 1;
		long result = 0;
		while(start <= end) {
			long h = (start+end)/2;
			
			long tmpSum = 0;
			for(int i = 0; i < n; i++) {
				if(arr[i]-h > 0) {
					tmpSum += (arr[i] - h);					
				}
			}
			
			if(tmpSum < m) {	// 나무가 부족 -> 높이 낮추기
				end = h-1;
			}else{	// 나무 과잉 -> 높이 올리기
				result = h;
				start = h+1;
			}
		}
		
		System.out.println(result);
		
	}

}
