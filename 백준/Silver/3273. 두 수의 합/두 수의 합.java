import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] nums = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		// 0. 정렬
		Arrays.sort(nums);
		
		// 1. 투포인터
		int left = 0;
		int right = n-1;
		int count = 0;
		int sum = 0;
		
		while(left < right) {
			sum = nums[left] + nums[right];
			
			if(sum == x) {
				count++;
				left++;
				right--;
			}else if(sum < x) {
				left++;
			}else {
				right--;
			}	
		}
		
		System.out.println(count);
	}

}
