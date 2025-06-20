import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		int [] arr = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		int [] cnt = new int[4];
		for(int i = 0; i < P; i++) {
			char ch = str.charAt(i);
			
			if(ch == 'A') cnt[0] += 1;
			else if(ch == 'C') cnt[1] += 1;
			else if(ch == 'G') cnt[2] += 1;
			else if(ch == 'T') cnt[3] += 1;
			
		}
		if(isValid(cnt, arr)) result++;
		
		for(int i = 1; i <= S-P; i++) {
			
			char pre = str.charAt(i-1);		// 이전 문자 개수 차감
			if(pre == 'A') cnt[0] -= 1;
			else if(pre == 'C') cnt[1] -= 1;
			else if(pre == 'G') cnt[2] -= 1;
			else if(pre == 'T') cnt[3] -= 1;
			
			char next = str.charAt(i+P-1);		// 이전 문자 개수 차감
			if(next == 'A') cnt[0] += 1;
			else if(next == 'C') cnt[1] += 1;
			else if(next == 'G') cnt[2] += 1;
			else if(next == 'T') cnt[3] += 1;	
			
			if(isValid(cnt, arr)) result++;
			
		}
		
		System.out.println(result);
		
	}
	
	static boolean isValid(int [] cnt, int [] arr) {
		for(int idx = 0; idx < 4; idx++) {
			if(cnt[idx] < arr[idx]) return false;
		}
		
		return true;
	}

}
