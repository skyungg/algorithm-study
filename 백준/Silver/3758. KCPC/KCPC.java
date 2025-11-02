import java.io.*;
import java.util.*;

/*
 * 총 k개의 문제 풂.
 * 한 문제에 대한 풀이 여러번 제출 가능 -> 그중 최고 점수가 그 문제에 대한 최종 점수 됨
 * 최종점수 : 각 문제에 대해 받은 점수의 총합
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int [][] team;
		int [][] score;
		for(int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// 팀의 개수
			int k = Integer.parseInt(st.nextToken());	// 문제의 개수
			int t = Integer.parseInt(st.nextToken());	// 당신 팀의 id
			int m = Integer.parseInt(st.nextToken());	// 로그 엔트리 개수
			
			team = new int[n+1][4];
			score = new int[k+1][n+1];	// 각 문제별 팀의 점수
			// 팀 번호, 최종점수, 제출 횟수, 마지막 제출 시간
			for(int idx = 1; idx <= n; idx++) team[idx][0] = idx;
			
			// 로그 기록
			for(int idx = 0; idx < m; idx++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());	// 팀 id
				int j = Integer.parseInt(st.nextToken());	// 문제 번호
				int s = Integer.parseInt(st.nextToken());	// 당획득한 점수
				
				team[i][2]++;		// 제출 횟수 갱신
				team[i][3] = idx;	// 마지막 제출 시간 갱신
				
				if(s > score[j][i]) {	// 기존 점수보다 높음 -> 갱신
					team[i][1] += s - score[j][i];
					score[j][i] = s;		// 현재 팀의 해당 문제에 대한 점수 갱신
				}
			}
			
			// 갱신하기
			Arrays.sort(team, (o1, o2) -> {
				if(o1[1] == o2[1]) {
					if(o1[2] == o2[2]) {
						return o1[3] - o2[3];		// 마지막 제출 시간 오름차순
					}else return o1[2] - o2[2];		// 제출 횟수 오름차순
				}else return o2[1] - o1[1];			// 총점 내림차순
				}
			);
			
			// 순위 구하기
			for(int idx = 0; idx < n; idx++) {
				if(team[idx][0] == t) {
					sb.append((idx+1)+"\n");
					break;
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
