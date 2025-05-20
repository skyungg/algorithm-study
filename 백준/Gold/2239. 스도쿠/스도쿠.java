import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/** 2023-09-27 : 코드 참고
 * [문제] BJ 2239 : 스토쿠
 * [아이디어] 백트래킹
 * 
 * @author 허승경
 *
 */
public class Main {
	static int[][] arr;	// 스토쿠 담을 2차원 배열
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 배열 입력받기
		arr = new int[9][9];
		list = new ArrayList<int[]>();
		for(int i = 0; i < 9; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < 9; j++) {
				arr[i][j] = tmp.charAt(j) - '0';	// int로 변환해서 저장
				
				// 2. 아직 채워지지 않은 곳의 좌표값을 리스트에 저장
				if(arr[i][j] == 0) list.add(new int[] {i, j});
			}
		}
		
		// 빈 곳 채우기
		gameStart(0);
		
	}

	static void gameStart(int level) {
		// 3. 
		if(list.size() == level) {	// 리스트의 사이즈와 같아질때까지돌리기
			goSudoku();		// 결과 출력하러 가기
			System.exit(0);
			//return; - > 초과
		}
		
		// 4. list에서 level 번째의 0인 위치 뽑아오기
		int x = list.get(level)[0];
		int y = list.get(level)[1];
		
		// 5. 방문 확인 배열 생성
		boolean [] isChecked = new boolean[10];	
		
		// 6. 이미 있는 칸 방문 확인 처리
		for(int i = 0; i < 9; i++) {	// 가로줄 확인(행고정, 열 이동)
			if(arr[x][i] != 0) {		// 이미 채워진 곳은 방문 확인 처리
				isChecked[arr[x][i]] = true;
			}
		}
		
		for(int i = 0; i < 9; i++) {	// 세로줄 확인(열 고정, 행 이동)
			if(arr[i][y] != 0) {		// 이미 채워진 곳은 방문 확인 처리
				isChecked[arr[i][y]] = true;
			}
		}
		
		int startX = (x/3)*3;		// 3*3 네모 박스에서의 확인
		int startY = (y/3)*3;
		for(int i = startX; i < startX + 3; i++) {
			for(int j = startY; j < startY + 3; j++) {
				if(arr[i][j] != 0) {
					isChecked[arr[i][j]] = true;
				}
			}
		}
		
		// 7. 1에서 9까지 아직 쓰지 않은 숫자 중에서 사전순대로 넣기
		for(int i = 1; i < 10; i++) {
			if(!isChecked[i]) {
				arr[x][y] = i;
				gameStart(level+1);		// 다음 단계로 진행
				arr[x][y] = 0;	// 다시 해당 자리 초기화(0) 
			}
		}
	}

	static void goSudoku() {
		// 8. 결과 출력
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println(); 		// 한줄 씩 띄우기
		}
		
	}

}
