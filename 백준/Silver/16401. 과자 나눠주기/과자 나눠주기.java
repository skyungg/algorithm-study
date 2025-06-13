import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());	// 조카 수
		int n = Integer.parseInt(st.nextToken());	// 과자 수
		int [] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); 	// 정렬
		
		long left = 1;
		long right = arr[n-1];
		long maxLength = 0;
		while(left <= right) {
			int cnt = 0;					// mid 길이로 나눠줄 수 있는 사람 수
			long mid = (left+right)/2;
			
			for(int i = 0; i < n; i++) {
				cnt += (arr[i]/mid);
			}
			
			if(cnt >= m) {
				maxLength = Math.max(maxLength, mid);
				left = mid+1;
			}else right = mid-1;
		}
		
		System.out.println(maxLength);
	}

}
