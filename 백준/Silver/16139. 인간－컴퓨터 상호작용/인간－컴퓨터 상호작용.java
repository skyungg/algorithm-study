import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			char alpha = (st.nextToken()).charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int i = l; i <= r; i++) {
				if(S.charAt(i) == alpha) cnt++;
			}
			
			sb.append(cnt+"\n");
		}
		
		// 정답 출력
		System.out.println(sb.toString());

	}

}
