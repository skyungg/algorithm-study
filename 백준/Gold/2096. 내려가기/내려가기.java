import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int [][] maxDp = new int[N+1][3];
		int [][] minDp = new int[N+1][3];
		maxDp[1][0] = arr[1][0];
		maxDp[1][1] = arr[1][1];
		maxDp[1][2] = arr[1][2];
		
		minDp[1][0] = arr[1][0];
		minDp[1][1] = arr[1][1];
		minDp[1][2] = arr[1][2];
		
		for(int i = 2; i <= N; i++) {
			maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + arr[i][0];
			maxDp[i][1] = Math.max(maxDp[i-1][1], Math.max(maxDp[i-1][0], maxDp[i-1][2])) + arr[i][1];
			maxDp[i][2] = Math.max(maxDp[i-1][2], maxDp[i-1][1]) + arr[i][2];
			
			minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + arr[i][0];
			minDp[i][1] = Math.min(minDp[i-1][1], Math.min(minDp[i-1][0], minDp[i-1][2])) + arr[i][1];
			minDp[i][2] = Math.min(minDp[i-1][2], minDp[i-1][1]) + arr[i][2];
			
		}
		
		System.out.println(Math.max(maxDp[N][0], Math.max(maxDp[N][1], maxDp[N][2]))
				+" "+Math.min(minDp[N][0], Math.min(minDp[N][1], minDp[N][2])));
		

	}

}
