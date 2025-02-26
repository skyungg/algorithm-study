import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [][] infoArr = new int[n][2];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			infoArr[i][0] = Integer.parseInt(st.nextToken());
			infoArr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 0. end 기준 오름차순 정렬하기
		Arrays.sort(infoArr, (a, b) -> {
			if(a[1] == b[1]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		
		// 1. 구현
		int result = 0;
		int endTime = 0;	// 종료시간
		for(int i = 0; i < n; i++) {
			if(infoArr[i][0] >= endTime) {
				endTime = infoArr[i][1];
				result++;
			}
		}
		
		System.out.println(result);

	}

}
