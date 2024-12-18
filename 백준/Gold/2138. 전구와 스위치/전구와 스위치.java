import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int cnt;
		String [] arr;
		
		public Point(int cnt, String [] arr) {
			this.cnt = cnt;
			this.arr = arr;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char [] arr = br.readLine().toCharArray();
		char [] answer = br.readLine().toCharArray();

		// 첫 번째 전구 킬 때, 안 킬때
		int result = Math.min(solve(arr.clone(), answer, n, true),
				solve(arr.clone(), answer, n, false));
		
		if(result != Integer.MAX_VALUE) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
	}
	
	static int solve(char [] arr, char [] answer, int n, boolean flag) {
		int count = 0;		// 누른 횟수
		
		if(flag) {
			press(arr, 0);
			count++;
		}
		
		// 두 번째 전구부터 순차적으로 처리
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != answer[i - 1]) {
                press(arr, i);
                count++;
            }
        }
        
        // 마지막 전구까지 목표 상태와 같은지 확인
        if (arr[n - 1] != answer[n - 1]) {
            return Integer.MAX_VALUE; // 불가능한 경우
        }
        
        return count;
	}
	
	static void press(char[] arr, int idx) {
	    // 현재 전구와 양 옆 전구를 반전
	    for (int i = idx - 1; i <= idx + 1; i++) {
	        if (i >= 0 && i < arr.length) {
	            if (arr[i] == '0') {
	                arr[i] = '1';
	            } else {
	                arr[i] = '0';
	            }
	        }
	    }
	}

}
