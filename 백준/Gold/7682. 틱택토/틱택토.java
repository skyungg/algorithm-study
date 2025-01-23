/*
 * 아이디어 : x의 개수의 = o의 개수 + 1
 * -> 개수로 판별하면 X
 * X와 O의 승리 여부 판단 및 유효성
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals("end")) break;
			char [][] map = new char[3][3];
			
			int xCnt = 0;
			int oCnt = 0;
			
			for(int i = 0; i < str.length(); i++) {
				map[i/3][i%3] = str.charAt(i);
				if(str.charAt(i) == 'X') xCnt += 1;
				else if(str.charAt(i) == 'O') oCnt += 1;
			}
			
			// 구현
			if(isValid(map, xCnt, oCnt)) {
				sb.append("valid"+"\n");
			}else {
				sb.append("invalid" + "\n");
			}
		}
		
		// 정답 출력
		System.out.println(sb.toString());
	}
	
	static boolean isValid(char [][] map, int xCnt, int oCnt) {
		// 1. 개수 ( X의 개수는 == O의개수 or O의 개수+1)
		if(xCnt != oCnt && xCnt != oCnt+1) return false;
		
		// 2. x와 o의 각각 승리 여부 판단
		boolean xFlag = isWinner(map, 'X');
		boolean oFlag = isWinner(map, 'O');
		
		// 3. 승리 조건 판단
		if(xFlag && oFlag) return false;	// 둘 다 우승 X
		
		if(xFlag && xCnt != oCnt+1) return false;	// X가 이길 수 있는 경우, x가 o의 개수보다 1개 더 많은 경우
		if(oFlag && xCnt != oCnt) return false;		// O가 이길 수 있는 경우 -> x와 o의 개수가 같을 경우
		if(!xFlag && !oFlag && xCnt+oCnt < 9) return false;	// 둘 다 지고 아직 판이 끝나지 않으면 false;
		
		return true;
	}
	
	static boolean isWinner(char [][] map, char ch) {
		// 1. 가로 및 세로 확인
		for(int i = 0; i < 3; i++) {
			if(map[i][0] == ch && map[i][1] == ch && map[i][2]== ch) return true;
			if(map[0][i] == ch && map[1][i] == ch && map[2][i] == ch) return true;
		}
		
		// 대각선
		if(map[0][0] == ch && map[1][1] == ch && map[2][2] == ch) return true;
		if(map[0][2] == ch && map[1][1] == ch && map[2][0] == ch) return true;
		
		return false;
	}
}
