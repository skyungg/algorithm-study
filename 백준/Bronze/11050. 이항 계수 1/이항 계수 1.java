import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(dfs(N, K));

	}
	
	static int dfs(int n, int k) {
		if(k == 0 || n == k) return 1;
		
		
		return dfs(n-1, k-1) + dfs(n-1, k);
	}

}
