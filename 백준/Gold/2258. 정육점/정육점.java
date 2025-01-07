import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long [][] arr = new long[n][2];	// 무게 및 가격 정보
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Long.parseLong(st.nextToken());
			arr[i][1] = Long.parseLong(st.nextToken());
		}
		
		// 정렬 (가격 -> 무게 )
		Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return Long.compare(b[0], a[0]); // 무게 내림차순
            } else {
                return Long.compare(a[1], b[1]); // 가격 오름차순
            }
        });
		
		
		long curWeight = 0;	// 전체 무게
		long curCost = 0;	// 현재비용
		long minRes = Long.MAX_VALUE;		// 최소 비용
		boolean flag = false;
		
		for(int i = 0; i < n; i++) {
			curWeight += arr[i][0];		// 지금까지의 무게
			curCost += arr[i][1];
			
			if (i > 0 && arr[i][1] != arr[i - 1][1]) {
				curCost = arr[i][1];
            }
			
			if (curWeight >= m) { // 목표 무게 충족
				flag = true;
				minRes = Math.min(minRes, curCost);
            }
		}
		
		if(!flag) {
			System.out.println(-1);
		}else {
			System.out.println(minRes);
		}
	}


}
