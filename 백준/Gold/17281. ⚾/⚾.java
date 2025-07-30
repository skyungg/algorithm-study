import java.io.*;
import java.util.*;

/*
 * 아이디어: 구현, 조합(-> 순열)?
 * 문제에서 요구하는 것 -> 타순 정해놓고 치렴.
 * 그럼 해야하는 것 -> 선수들 타순 정하기
 * 이때 고려해야할 것 -> 점수를 극대화할 수 있는 타순을 하삼.
 * */

public class Main {
	static int N;
	static int [][] score;
	static int [] permutation;	// permutation[i] = i번째 타자 번호
	static boolean [] visited;
	static int maxScore;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 이닝 수
		
		score = new int[N][9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 순열 만들기
		permutation = new int[9];
		visited = new boolean[9];
		
		permutation[3] = 0;	// 1번 선수는 항상 4번타자로 고정
		visited[3] = true;
		maxScore = 0;
		makeLineUp(1);
		
		System.out.println(maxScore);
	}
	
	static void makeLineUp(int num) {
		if(num == 9) {	// 오늘 타순 확정(순열 다 만듦)
			start();	// 현재 라인업으로 경기 시작
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			permutation[i] = num;
			makeLineUp(num+1);
			visited[i] = false;
		}
	}
	
	static void start() {		
		int idx = 0;	// 현재 공격인 선수
		int total_score = 0;	//이번 라인업으로 얻을 수 있는 점수
		
		for(int i = 0; i < N; i++) {
			int outCount = 0;	// 이번 이닝 아웃카운트
			boolean [] base = new boolean[3];	// 1루 ~3루까지 진출 상황(true: 진출함. false: 비어있음)
			
			while(outCount < 3) {		// 아웃카운트 3회 누적 전까지, 계속 공격
				int player = permutation[idx];	// 현재 타자 번호
				int result = score[i][player];	// 이번 이닝에서 현재 타자가 친 결과
				
				if(result == 0) {	// 아웃
					outCount++;
				}else if(result == 1) {		// 안타
					if(base[2]) total_score++;		// 3루에 있는 경우 홈으로 들어옴 -> 1점 획득
					
					base[2] = base[1];
					base[1] = base[0];
					base[0] = true;		// 타자는 1루 진출
				}else if(result == 2) {		// 2루타
					if(base[2]) total_score++;		// 3루, 2루에 있는 경우 무조건 홈 -> 점수 획득
					if(base[1]) total_score++;
					
					base[2] = base[0];
					base[1] = true;		// 타자는 2루 진출
					base[0] = false;
				}else if(result == 3) {		// 3루타
					if(base[2]) total_score++;		// 3루, 2루, 1루 에 있는 경우 무조건 홈 -> 점수 획득
					if(base[1]) total_score++;
					if(base[0]) total_score++;
					
					base[2] = true;		// 타자는 3루 진출
					base[1] = false;		// 타자는 2루 진출
					base[0] = false;
				}else if(result == 4) {		// 홈런
					total_score++;	// 현재 타자 홈
					if(base[2]) total_score++;		// 3루, 2루, 1루 에 있는 경우 무조건 홈 -> 점수 획득
					if(base[1]) total_score++;
					if(base[0]) total_score++;
					
					base[2] = false;		// 타자는 3루 진출
					base[1] = false;		// 타자는 2루 진출
					base[0] = false;
				}

				
				idx = (idx+1)%9;
			}
		}	

		maxScore = Math.max(maxScore,  total_score);
	}

}
