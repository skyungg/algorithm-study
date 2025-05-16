import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 정렬 -> 내림차순
		Arrays.sort(arr);
		
		int maxWeight = 0;		// 최댓값
		int cnt = 1;
		for(int i = n-1; i >= 0; i--) {
			int tmp = arr[i] * cnt++;	// index 0부터 시작
			maxWeight = Math.max(maxWeight, tmp);
		}
		
		System.out.println(maxWeight);
	}

}
