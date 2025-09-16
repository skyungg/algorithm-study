import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 나무 수
		long M = Integer.parseInt(st.nextToken());	// 가져갈 나무 합
		
		long [] tree = new long[N];
		long start = 0;
		long end = -1;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end,  tree[i]);
		}
		
		
		long maxHeight = 0;
		while(start <= end) {
			long mid = (start + end)/2;
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				if(tree[i] - mid > 0 ) sum += (tree[i]-mid);
			}
			
			if(sum >= M) {
				maxHeight = Math.max(maxHeight, mid);
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		System.out.println(maxHeight);
	}

}
