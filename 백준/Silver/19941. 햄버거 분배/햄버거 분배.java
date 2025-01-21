/**
 * 아이디어 : 가장 왼쪽에 있는 걸 먹어야 최대한 많은 사람이 햄버거 먹음!
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		String [] arr = new String[n];
		arr = br.readLine().split("");
		
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals("P")) {
				int start = Math.max(i-k, 0);	// 0부터 i-k까지 가장 큰값(가장 왼쪽값)
				int end = Math.min(i+k,  n-1);	// i+k부터 n-1까지, 가장 작은값(가장 왼쪽값)
				
				for(int j = start; j <= end; j++) {
					if(arr[j].equals("H")) {
						count++;
						arr[j] = "O";	// 방문 배열대신 문자열 변환
						break;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
