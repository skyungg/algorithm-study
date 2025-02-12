import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i = 1; i <= n; i++) {
			// 구현
			String [] nums = String.valueOf(i).split("");		// 자릿수
			int tmp = i;
			for(int j = 0; j < nums.length; j++) {
				tmp += Integer.parseInt(nums[j]);
			}
			
			if(tmp == n) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

}
