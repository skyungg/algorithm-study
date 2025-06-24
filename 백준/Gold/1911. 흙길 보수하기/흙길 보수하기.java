import java.io.*;
import java.util.*;

/*
 * 아이디어: 그리디
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> {
			if(a[0] == b[0]) return a[1]-b[1];
			else return a[0]-b[0];
		});	// 시작위치 기준 오름차순 정렬하기
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new int[] {start, end});
		}
		
		// 구하기
		int end = 0;	// 널빤지 마지막 위치
		int count = 0;	// 널빤지 개수
		
		while(!pq.isEmpty()) {
			int [] curPoint = pq.poll();
			
			
			if(curPoint[1] <= end) continue;	// 이미 덮은 위치 -> 이동하기
			
			int start = Math.max(curPoint[0], end);		// 시작 위치 구하기
			int length = curPoint[1] - start;	// 덮어야 할 물웅덩이 길이
			
			int cnt = (length/L);
			if(length%L != 0) cnt++;	// 떨어지지 않을 때 -> 하나 더 필요함
			
			count += cnt;
			end = start + cnt*L;
		}
		
		System.out.println(count);
	}

}
