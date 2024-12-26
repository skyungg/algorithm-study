import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int [] arr = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 1;
		int end = n;
		int minH = n;		// 최대 높이를 기본값으로 설정
		int mid = 0;

		while(start <= end) {
			mid = (start+end)/2;	// 중간값
			
			boolean flag = true;	// 가능 여부
			int idx = 0;	// 마지막 비춰진 위치(초기 위치: 0부터)
			
			for(int h : arr) {
				if(h - mid > idx) {		// 가로등의 왼쪽 방향 가능 여부 판단
					flag = false;
					break;
				}
				idx = h+mid;	// 가로등 +영향권(오른쪽 방향)
			}
			
			if(idx < n) flag = false;	// 실패
			
			if(flag) {
				minH = mid;
				end = mid-1;
			}else {
				start = mid+1;	// 시작위치 증가
			}
		}
		System.out.println(minH);
	}
}
