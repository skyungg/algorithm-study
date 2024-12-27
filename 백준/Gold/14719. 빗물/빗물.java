import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		if(w <= 2) {
			System.out.println(0);
			return;
		}
		
		int map [] = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < w; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int [] left = new int[w];	// 왼쪽 최대
		int [] right = new int[w];	// 오른쪽 최대
		
		// 왼쪽에서 가장 높은 벽
		left[0] = map[0];
		for(int i = 1; i < w; i++) {
			left[i] = Math.max(left[i-1], map[i]);
		}
		
		// 오른쪽에서 가장 높은 벽
		right[w-1] = map[w-1];
		for(int i = w-2; i >= 0; i--) {
			right[i] = Math.max(right[i+1], map[i]);
		}
		
		int result = 0;
		for(int i = 1; i < w-1; i++) {
			int tmp = Math.min(left[i], right[i]) - map[i];
			if(tmp > 0) result+=tmp;
		}
		System.out.println(result);
	}

}
