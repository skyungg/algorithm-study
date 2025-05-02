import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);		// 원소 총 개수
		long [] nums = new long[n];
		int start = 0;
		for(int i = 1; i < tmp.length; i++) {
			if (tmp[i].isEmpty()) continue;
			StringBuilder sb = new StringBuilder();
			sb.append(tmp[i]);
			String num = sb.reverse().toString();
			nums[start++] = Long.parseLong(num);
		}
		
		while(start < n) {
			String [] arr = br.readLine().split(" ");
			
			for(int i = 0; i < arr.length; i++) {
				if (arr[i].isEmpty()) continue;
				StringBuilder sb = new StringBuilder();
				sb.append(arr[i]);
				String num = sb.reverse().toString();
				nums[start++] = Long.parseLong(num);
			}
			
		}
		
		Arrays.sort(nums);
		
		for(long num : nums) {
			System.out.println(num);
		}

	}

}
