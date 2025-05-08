import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 접시 수
		int d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
		
		int [] arr = new int[n+k];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(i < k) {
				arr[n+i] = arr[i];
			}
		}
		
		int [] count = new int[d+1];
		int cnt = 0;	// 겹치지 않는 초밥 수
		
		 // 초기화
		for(int i = 0; i < k; i++) {
			if(count[arr[i]]++ == 0) cnt++;	// 처음 등장한 경우 
		}
		
		int maxCnt = cnt;	// 겹치지 않는 초밥의 최대 종류
		if(count[c] == 0) {
			maxCnt++;
		}
		
		for(int i = 1; i < n; i++) {
			// i -> 현재 사이클 시작 순서
			if(--count[arr[i-1]] == 0) cnt--;	// 이전값 감소
			if(++count[arr[i+k-1]] == 1) cnt++;	// 현재사이클 마지막값 추가
			
			int tmp = cnt;
			if(count[c] == 0)tmp++;
			maxCnt = Math.max(maxCnt, tmp);
		}

		System.out.println(maxCnt);

	}

}
