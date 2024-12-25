import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Long score = Long.parseLong(st.nextToken());
		
		if(n == 0) {
			System.out.println(1);
			return;
		}
		
		int p = Integer.parseInt(st.nextToken());
		int rank = 1;	// 랭킹
		int cnt = p;
		String [] tmp = br.readLine().split(" ");
		
		Set<Long> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			Long key = Long.parseLong(tmp[i]);
			if(key < score) continue;
			cnt--;
			if(key > score) rank++;
			
			if(rank > p || cnt <= 0) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(rank);
	}

}
