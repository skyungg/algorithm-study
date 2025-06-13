import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 과자 수
		long [] arr = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr); 	// 정렬

		long minValue = Long.MAX_VALUE;
		int minLeftIdx = 0;
		int minRightIdx = 0;
		int left = 0;
		int right = n-1;

		while(left < right) {
			long sum = arr[left]+arr[right];
			
			if(Math.abs(sum) < minValue) {
				minValue = Math.abs(sum);				// 갱신
				minLeftIdx = left;
				minRightIdx = right;
			}
			if(sum > 0) right--;
			else if (sum < 0) left++; 
			else break;
		}
		
		System.out.println(arr[minLeftIdx]+" "+arr[minRightIdx]);
	}

}
