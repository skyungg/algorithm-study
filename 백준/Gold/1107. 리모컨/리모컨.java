import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 100) {
			System.out.println(0);
			return;
		}
		
		int m = Integer.parseInt(br.readLine());
		boolean [] isBroken = new boolean[10];	//	 0 ~ 9 까지 사용 가능
		
		if(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int minCount = Math.abs(n - 100);		// 최댓값은 방향키로 움직인 값
		
		for(int i = 0; i <= 1000000; i++) {
			if(check(i, isBroken)) {
				int cnt = String.valueOf(i).length();
				cnt += Math.abs(i - n);
				minCount = Math.min(minCount, cnt);
			}
		}
		System.out.println(minCount);
	}
	
	static boolean check(int i, boolean [] isBroken) {
		if(i == 0) {
			return !isBroken[0];
		}
		
		while(i > 0) {
			if(isBroken[i%10]) return false;	// 고장난 버튼
			
			i /= 10;
		}
		return true;
	}
}
