import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		long n = Long.parseLong(st.nextToken());
		
		long start = 1;
		long end = 0;
		
		long [] arr = new long[k];
		for(int i = 0; i < k; i++) {
			arr[i] = Long.parseLong(br.readLine());
			end = Math.max(end,  arr[i]);
		}
		
		long result = 0;
		while(start <= end) {
			long mid = (start + end)/2;
			
			long tmpSum = 0;
			for(int i = 0; i < k; i++) {
				if(arr[i] >= mid) {
					tmpSum += (arr[i] / mid);
				}
			}
			
			if(tmpSum >= n) {
				start = mid + 1;
				result = mid;
			}else {
				end = mid - 1;
			}
		}	
		System.out.println(result);
	}
}
