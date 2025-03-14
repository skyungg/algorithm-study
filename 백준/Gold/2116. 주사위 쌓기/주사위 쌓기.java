/*
 * 아이디어: 완전탐색
 * 1. 첫번째 주사위를 (A, F), (B, D), (C, E), (D, B), (E, C), (F, A) 순서로 만들기
 * 2. 나머지 주사위에서 윗면과 아랫면 찾아가기
 * 3. 2의 해당되는 인덱스 제외하고 현재 주사위에서 최댓값 찾기
 * 4. 위의 과정을 남은 주사위에서 돌고 최댓값의 합 구하기
 * 5. 하나의 케이스 끝날 때, 최댓값들의 합 return
 * 6. 각 케이스별 최댓값의 합 갱신
 * 7. 최종 결과 출력
 * */

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int [][] arr;
	static int [] opp = {5, 3, 4, 1, 2, 0};		// 반대편 주사위 면

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][6];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxSum = 0;
		for(int i = 0; i < 6; i++) {	// 첫 번째 주사위 기준, 6면을 아랫면으로 할 경우 탐색
			int sum = getMaxSum(i);		// 현재 주사위 기준 최대 사이드합
			maxSum = Math.max(maxSum, sum);
		}
		
		System.out.println(maxSum);
	}
	
	static int getMaxSum(int startIdx) {
		int bottomValue = arr[0][startIdx];		// 첫 번째 주사위 아랫면 값
		int topValue = arr[0][opp[startIdx]];	// 첫 번째 주사위 윗면 값
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			if(i > 0) {
				bottomValue = topValue;		// 현재 주사위 아랫면 값 -> 이전 주사위 윗면 값
			}
			
			int bottomIdx = findIndex(arr[i], bottomValue);
            int topIdx = opp[bottomIdx];	// 현재 주사윗면의 인덱스
            topValue = arr[i][topIdx];		// 현재 주사위 윗값
            
            int maxSide = 0;
            for(int j = 0; j < 6; j++) {
            	if(j != bottomIdx && j != topIdx) {
            		maxSide = Math.max(maxSide, arr[i][j]);
            	}
            }
            sum += maxSide;
			
           
		}
		return sum;
	}
	
	static int findIndex(int [] tmp, int target) {
		for(int i = 0; i < 6; i++) {
			if(tmp[i] == target) {
				return i;
			}
		}
		return -1;	// 없는 경우
	}

}
