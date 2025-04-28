import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		long sum = 0;
		long maxValue = Long.MIN_VALUE;
		
		while(left <= right && right < n) {
			
			sum += nums[right++];
			
			if(right-left == k) {
				maxValue = Math.max(maxValue, sum);
				sum -= nums[left++];
				
			}
		}
		
		System.out.println(maxValue);
				
	}

}
