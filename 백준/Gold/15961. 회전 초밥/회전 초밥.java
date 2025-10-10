import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		int N = Integer.parseInt(st.nextToken());		// 접시 수
		int d = Integer.parseInt(st.nextToken());		// 초밥 종류
		int k = Integer.parseInt(st.nextToken());		// 연속 접시 수
		int c = Integer.parseInt(st.nextToken());		// 쿠폰 번호
		
		int [] arr = new int[2*N];	
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arr[i+N] = arr[i];
		}
		
		// 구현
		int [] sushi = new int[d+1];	// 초밥 종류
		Set<Integer> set = new HashSet<>();
		sushi[c]++;		// 쿠폰 초밥 종류 1증가
		set.add(c);
		
		for(int i = 0; i < k; i++) {
			set.add(arr[i]);
			sushi[arr[i]]++;
		}
		
		int count = set.size();		// 현재 set 사이즈를 count 초기화
		 
		for(int i = k; i < N+k; i++) {
			sushi[arr[i-k]]--;		//  이전 연속에서 가장 첫 번째 접시 빼기
			if(sushi[arr[i-k]] == 0) {		// 해당 초밥 종류가 존재 X -> set에서도 삭제 
				set.remove(arr[i-k]);
			}
			
			set.add(arr[i]);		// 현재 위치 접시 추가하기
			sushi[arr[i]]++;		// 해당 초밥 종류 증가 
			
			count = Math.max(count, set.size());
		}
		
		System.out.println(count);

	}

}
