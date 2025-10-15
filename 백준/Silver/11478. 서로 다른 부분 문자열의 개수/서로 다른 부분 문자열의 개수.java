import java.io.*;
import java.util.*;

/*
 * (구) 문자열의 서로 다른 부분 문자열의 개수
 * 아이디어: 구현, set
 * 1. 1부터 문자열의 길이만큼 부분 문자열의 개수 구하기 
 * 2. set에 저장
 * 3. set의 크기 출력 
 * */

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i < str.length(); i++) {
			String tmp = Character.toString(str.charAt(i));
			set.add(tmp);
			for(int j = i+1; j < str.length(); j++) {
				tmp += Character.toString(str.charAt(j));
				set.add(tmp);
			}
		}
		
		System.out.println(set.size());
		

	}

}
