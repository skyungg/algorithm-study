import java.io.*;
import java.util.*;

public class Main {
	static int n, m;	
	static long [][] arr;		// arr[i][j]의 최댓값 10^8 

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
	
		arr = new long [n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		for(int i = 0; i < r; i++) {
			rotate();
		}
		
		StringBuilder sb = new StringBuilder();
		for(long [] ar : arr) {
			for(int i = 0; i < ar.length; i++) {
				sb.append(ar[i]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	static void rotate() {
		for(int i = 0; i < Math.min(n,  m)/2; i++) {
			long tmp = arr[i][i];
			
			//오른쪽 -> 왼쪽
			for(int j = i; j < m-i-1; j++) {
				arr[i][j] = arr[i][j+1];
			}
			
			// 아래 -> 위
			for(int j = i; j < n-i-1; j++) {
				arr[j][m-i-1] = arr[j+1][m-i-1];
			}
			
			// 왼쪽 -> 오른쪽
			for(int j = m-i-1; j > i; j--) {
				arr[n-i-1][j] = arr[n-i-1][j-1];
			}
			
			// 위 -> 아래
			for(int j = n-i-1; j > i; j--) {
				arr[j][i] = arr[j-1][i];
			}
			
			arr[i+1][i] = tmp;
			
		}
	}

}
