import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		// 계산하기
		long answer = 0;
		for(int a : arr) {
			a -= b;		// 총 감독관 응시생 감소
			answer++;	// 총감독관 -> 무조건 배치
			
			if(a > 0) {
				answer += a/c;
				
				if(a%c > 0) answer++;
			}
		}
		
		System.out.println(answer);

	}

}
