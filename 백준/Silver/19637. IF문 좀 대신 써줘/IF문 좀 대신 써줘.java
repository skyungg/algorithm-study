/*
 * 초기 아이디어 : hashMap 활용
 * 1. set에 key: 숫자, value: 칭호의 이름 
 * 2. set 오름차순 정렬
 * 3. for문 돌면서 i < <= i+1 범위 찾기
 * -> 결과 : 문제 제대로 안 읽음(비내림차순 정렬로 이미 주어짐) 및 시간초과 발생
 * 
 * 개선 아이디어 : 이분탐색
 * 1. 10의 6승보다 작아서 long말고 int로 해도 충분!
 * 
 * */
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String [] names = new String[n];
		int [] powers = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			names[i] = st.nextToken();
			powers[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int curNum = Integer.parseInt(br.readLine());
			
			int start = 0;
			int end = n-1;
			
			while(start < end) {
				int mid = (start+end)/2;
				
				if(powers[mid] >= curNum) end = mid;
				else start = mid + 1;
			}
			
			sb.append(names[start]+"\n");
		}
		
		System.out.println(sb.toString());
		
	}

}
