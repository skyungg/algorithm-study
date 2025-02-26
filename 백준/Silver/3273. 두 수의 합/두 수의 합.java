import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		long x;
		long y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long [] nums = new long[(int) n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		long x = Long.parseLong(br.readLine());
		
		HashSet<Point> set = new HashSet<>();
		
		// 0. 정렬
		Arrays.sort(nums);
		
		// 1. 구현
		for(int i = 0; i < n; i++) {
			long curNum = nums[i];
			int left = i+1;
			int right = (int) n-1;
			
			while(left <= right) {
				int mid = (left+right)/2;
				
				if(mid < 0 || mid >= n) break;
				
				long sum = curNum + nums[mid];
				
				if(sum == x) {
					set.add(new Point(curNum, nums[mid]));
					break;
				}else if(sum < x) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
			
			
		}
		
		System.out.println(set.size());
	}

}
