import java.io.*;
import java.util.*;

/*
 * 아이디어: 우선순위?
 * 1. 통과한 점수 값이 가장 낮을 때
 * 2. 다섯 번째 주자가 가장 빨리 들어온 팀
 * 여서 명의 주자가 참가히지 못한 팀은 점수 계산 제외
 * */
public class Main {
	static class Point{
		int total_cnt = 0;		// 전체 주자수
		int sum = 0;			// 합
		int idx = 0;			// 마지막 주자 인덱스
		int cnt = 0;			// 지금까지 처리한 팀원수
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int [] nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			// 1. 팀별 인원 수 세기
			Map<Integer, Point> map = new HashMap<>();
			for (int num : nums) {
				map.putIfAbsent(num, new Point());
				map.get(num).total_cnt++;
			}
			
			// 2. 6명 모인 팀만 점수 계산
			int rank = 1;
            for (int num : nums) {
            	Point p = map.get(num);
                if (p.total_cnt < 6) continue; // 탈락 팀
                p.cnt++;
                if (p.cnt <= 4) p.sum += rank;     // 상위 4명 점수
                else if (p.cnt == 5) p.idx = rank; // 5번째 주자
                rank++;
            }
            
            // 3. 우승팀 선정
            int result = 0;
            int minScore = Integer.MAX_VALUE;
            int minFifth = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Point> e : map.entrySet()) {
                Point p = e.getValue();
                if (p.total_cnt < 6) continue;
                if (p.sum < minScore ||
                   (p.sum == minScore && p.idx < minFifth)) {
                    minScore = p.sum;
                    minFifth = p.idx;
                    result = e.getKey();
                }
            }
            
            sb.append(result+"\n");
		}
		System.out.println(sb);

	}

}
