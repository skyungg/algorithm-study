import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i = n-1; i > 0; i--) {
			int target = arr[i];
			
			for(int j = 0; j < i; j++) {
				while(arr[j] >= target) {
					cnt++;
					arr[j]--;
				}
			}
		}

		System.out.println(cnt);
		
	}

}
