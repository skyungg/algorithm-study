import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int [][] nums = new int[n][2];
		for(int i = 0; i < n; i++) {
			 st = new StringTokenizer(br.readLine());
			 nums[i][0] = Integer.parseInt(st.nextToken());
			 nums[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums, (a, b) -> {
			if(a[1] == b[1]) return a[0] - b[0];	// x좌표 오름차순
			else return a[1] - b[1];			// y좌표 오름차순
		});
		
		for(int [] num : nums) {
			System.out.println(num[0]+" "+num[1]);
		}
		
	}

}
