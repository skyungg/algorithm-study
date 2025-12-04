import java.io.*;
import java.util.*;

/*
 * 아이디어: 조합 구현
 * */
public class Main {
	static int K;
	static int [] nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String [] tmp = br.readLine().split(" ");
			
			if(tmp[0].equals("0")) break;	// 종료
			
			K = Integer.parseInt(tmp[0]);
		
			nums = new int[K];
			for(int i = 0; i < K; i++) {
				nums[i] = Integer.parseInt(tmp[i+1]);
			}
			
			// K개에서 6개 뽑기
			combination(0, 0, new int[6]);
			sb.append("\n");
		}
		
		// 결과 출력 
		System.out.println(sb);
	}
	
	static void combination(int cnt, int idx, int [] arr) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i < K; i++) {
			arr[cnt] = nums[i];
			combination(cnt+1, i+1, arr);
		}
	}

}
