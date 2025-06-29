import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int num;
		int cnt;
		int startAt;
		boolean isFrame;
		
		public Point(int num, int cnt, int startAt, boolean isFrame) {
			this.num = num;
			this.cnt = cnt;
			this.startAt = startAt;
			this.isFrame = isFrame;
		}
		
		@Override
		public int compareTo(Point p) {
			if(this.cnt == p.cnt) return this.startAt - p.startAt;
			else return this.cnt - p.cnt;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());
		
		List<Point> list = new ArrayList<>();
		Point[] arr = new Point[101];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < count; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 처음 입력 받은 경우
			if(arr[num] == null) {
				arr[num] =  new Point(num, 0, 0, false);
			}
			
			// 이미 존재
			if(arr[num].isFrame) {	// 게시된 경우 -> 추천 수 증가
				arr[num].cnt++;
			}else {
				if(list.size() == N) {		// 비어있는 액자 X
					// 정렬
					Collections.sort(list);
					Point removeStudent = list.remove(0);		// 가자 추천수 적은 학생 제거
					removeStudent.isFrame = false;	// 액자 탈퇴
					removeStudent.cnt = 0;		// 추천수 초기화
				}
				
				// 새로운 학생 추가
				arr[num].cnt = 1;
				arr[num].startAt = i;
				arr[num].isFrame = true;
				list.add(arr[num]);
			}
		}
		List<Integer> result = new ArrayList<>();
		for(Point p : list) {
			result.add(p.num);
		}
		// 정렬
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		for(int num : result) sb.append(num+" ");
		
		System.out.println(sb.toString());
	

	}

}
