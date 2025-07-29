import java.io.*;
import java.util.*;

/*
 * 아이디어: 구현
 * 1. 현재 (r, c)값이랑 k값 동이 여부 확인
 * 	-> 맞다면 return;, 아니라면 2번부터 수행
 * 2. 행, 열 개수 판단
 * 3. r-c 연산 판단 
 * 4. 재귀 
 * */
public class Main {
	static class Point implements Comparable<Point>{
		int num;
		int freq;
		
		public Point(int num, int freq) {
			this.num = num;
			this.freq = freq;
		}
		
		@Override
		public int compareTo(Point p) {	// 1.빈도수 오름차순, 2. 숫자 오름차순
			if(this.freq == p.freq) return this.num - p.num;
			return this.freq - p.freq;
		}
	}
	static int r, c, k;
	static int [][] arr = new int[101][101];
	static int rSize, cSize;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rSize = 3;	// 행-열 초기 크기
		cSize = 3;
		int result = -1;
		int time = 0;
		while(time <= 100) {
			if(arr[r][c] == k) {	// 발견
				result = time;
				break;	// 발견
			}
			
			if(rSize >= cSize) {	// R연산
				rCal();
			}else {					// C연산
				cCal();
			}
			
			time++;		// 연산 후, 시간 증가
		};
		
		// 정답 출력
		System.out.println(result);
	}
	
	static void rCal() {
		int [][] reArr = new int[101][101];	// 연산에서 쓸 2차원 배열
		for(int r = 0; r < rSize; r++) {
			HashMap<Integer, Integer> map = new HashMap<>();	// 현재 행에서 작성 할, 빈도수
			for(int c = 0; c < cSize; c++) {
				if(arr[r][c] != 0) {
					map.put(arr[r][c], map.getOrDefault(arr[r][c], 0)+1);					
				}
			}
			
			// map -> 리스트로 변환하기
			List<Point> list = new ArrayList<>();
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				list.add(new Point(entry.getKey(), entry.getValue()));
			}
			// 열 크기 갱신
			cSize = Math.max(cSize, list.size()*2);	// 2배이유 -> (숫자 빈도수) 이렇게 숫자만큼 들어나니까
			Collections.sort(list); 	// 정렬하기
			
			// 배열에 넣기
			for(int i = 0; i < list.size(); i++) {
				if(i >= 50) break;	// (숫자 빈도수) 두 개 다 위치하니까, 50넘으면 그 이후로는 진행 못 함
				
				Point p = list.get(i);
				reArr[r][2*i] = p.num;			// 숫자
				reArr[r][2*i+1] = p.freq;		// 빈도수
			}
		}
		
		cSize = Math.min(cSize, 100);
		arr = reArr;
	}
	
	static void cCal() {
		int [][] reArr = new int[101][101];	// 연산에서 쓸 2차원 배열
		for(int c = 0; c < cSize; c++) {
			HashMap<Integer, Integer> map = new HashMap<>();	// 현재 열에서, 작성 할 빈도수
			for(int r = 0; r < rSize; r++) {
				if(arr[r][c] != 0) {
					map.put(arr[r][c], map.getOrDefault(arr[r][c], 0)+1);					
				}
			}
			
			// map -> 리스트로 변환하기
			List<Point> list = new ArrayList<>();
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				list.add(new Point(entry.getKey(), entry.getValue()));
			}
			// 행 크기 갱신
			rSize = Math.max(rSize, list.size()*2);	
			Collections.sort(list); 	// 정렬하기
			
			// 배열에 넣기
			for(int i = 0; i < list.size(); i++) {
				if(i >= 50) break;	// (숫자 빈도수) 두 개 다 위치하니까, 50넘으면 그 이후로는 진행 못 함
				
				Point p = list.get(i);
				reArr[2*i][c] = p.num;			// 숫자
				reArr[2*i+1][c] = p.freq;		// 빈도수
			}
		}
		
		rSize = Math.min(rSize, 100);
		arr = reArr;
	}
	

}
