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
		
		// DP
		List<List<Integer>> path = new ArrayList<>();
		path.add(new ArrayList<>());
		for(int i = 0; i < n; i++) path.add(new ArrayList<>());
		
		int [] dp = new int[n];
		int maxLength = 1;
		int maxIdx = 0;
		dp[0] = 1;	// 첫 번째 원소는 자기 자신만 포함
		path.get(0).add(arr[0]);	// 첫 번째 원소 경로 초기 설정
		
		for(int i = 1; i < n; i++) {
			int tmpLength = 0;
			int idx = -1;
			// 이전 값 중, 가장 긴 증가하는 부분 수열 찾기
			for(int j = i-1; j >= 0; j--) {
				if(arr[j] < arr[i]) {
					if(tmpLength < dp[j]) {
						idx = j;
						tmpLength = dp[j];
					}
				}
			}
			
			// 경로 저장하기
			if(idx == -1) {	// 자기 자신만 존재
				path.get(i).add(arr[i]);	
			}else {
				// 이전 경로
				for(int k = 0; k < path.get(idx).size(); k++) {
					path.get(i).add(path.get(idx).get(k));
				}
				// 현재 값 추가
				path.get(i).add(arr[i]);
			}
			
			if(tmpLength == 0) dp[i] = 1;	// 자기 자신만 존재
			else dp[i] = tmpLength+1;
			
			if(maxLength < dp[i]) {
				maxLength = dp[i];
				maxIdx = i;
			}
		}
		
		System.out.println(maxLength);
		for(int num : path.get(maxIdx)) {
			System.out.print(num+" ");
		}
		
		
	}

}
