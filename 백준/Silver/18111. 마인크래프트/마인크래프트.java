import java.io.*;
import java.util.*;

/*
 * 아이디어: 완탐
 * (1) 블록제거 -> 2초
 * (2) inventory에서 가져오기 -> 1초
 * */

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());	
		int B = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[N][M];
		int [] heightCount = new int[257];	// 땅 높이 빈도수
				
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				heightCount[map[i][j]]++;
			}
		}
		
		// 구현하기
		int resultTime = Integer.MAX_VALUE;
		int resultHeight = -1;
		
		for(int h = 0; h < heightCount.length; h++) {
			int time = 0;		// h 기준으로 맞추는데 드는 시간
			int block = B;		// 인벤토리에 저장된 블록 수 
			
			for(int j = 0; j < heightCount.length; j++) {
				int count = heightCount[j];
				int diff = j - h;
				
				if(diff > 0) {		// 기준 높이보다 높은 경우 -> 블록 제거하기
					int removeCount = diff*count;	// 제거해서 맞춰야 할 블록 개수
					time += removeCount*2;		// 소요될 시간
					block += removeCount;		// 제거한 블록 inventory에 저장하기	
				}else if(diff < 0) {	// 기준 높이보다 낮은 경우 -> inventory에서 꺼내 쓰기
					// 블록 꺼내기
					int installCount = (-diff)*count;	// 쌓아야 할 블록 수
					time += installCount*1;		// 소요될 시간
					block -= installCount;	// 제거한 블록 inventory에 저장하기	
				}
			}
			
			// 현재 높이로 가능한지 확인하기
			if(block >= 0) {
				if(time < resultTime || (time == resultTime && h > resultHeight)) {
					resultTime = time;
					resultHeight = h;
				}
			}
		}
		
		System.out.println(resultTime+" "+resultHeight);

	}
}
