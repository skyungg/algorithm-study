import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
		
		while(true) {
			String str = br.readLine();
			if(str.equals("end")) break;
			boolean isVowel = false;	// 모음 포함 여부
			boolean flag = true;
			int vCount = 0;
			int cCount = 0;
			
			// 모음 하나 포함
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				// 1. 모음 포함 여부
				if(list.contains(ch)) {
					isVowel = true;
					vCount++;
					cCount = 0;
				}else {
					vCount = 0;
					cCount++;
				}
				
				// 2. 모음 3개 연속, 자음 3개 연속
				if(vCount >= 3 || cCount >= 3) {
					flag = false;
					break;
				}
				
				// 3. 같은 글자 연속 두번 X
				if(i > 0 && ch == str.charAt(i-1)) {
					if(!(ch == 'e' || ch == 'o')) {
						flag = false;
						break;
					}
				}
			}

			if(!isVowel) flag = false;
			
			
			if(!flag) {
				sb.append("<"+str+">"+" is not acceptable.\n");
			}else {
				sb.append("<"+str+">"+" is acceptable.\n");
			}
		}
		System.out.println(sb.toString());
	}

}
