import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}

		for(int i = 0; i < m; i++) {
			long a = pq.poll();
			long b = pq.poll();
			
			long c = a+b;
			int cnt = 0;
			while(cnt < 2) {
				pq.add(c);
				cnt++;
			}
		}
		
		long answer = 0;
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		
		System.out.println(answer);
	}

}
