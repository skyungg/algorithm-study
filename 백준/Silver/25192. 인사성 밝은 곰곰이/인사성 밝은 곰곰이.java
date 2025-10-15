/* 아이디어: SET
 * (구) 곰곰티콘 사용된 횟수 구하기
 * 1.ENTER -> 새로운 사람 입장
 * 2.그 외 -> 채팅 입력한 유저 닉네임 (숫자, 영어대소문자)
 * 
 * */
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		Set<String> set = new HashSet<>();		// 곰곰티콘 수 체크
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.equals("ENTER")) {		// 새로운 사람 입장 -> set 초기화
				set.clear();
			}else {		// 곰곰티콘인지, 인사인지 구분하기
				if(!set.contains(str)) {	// 곰곰티콘으로 인사 아직 안 한 사람
					set.add(str);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
