import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int cnt0 = 0;	// 0의 개수
		int cnt1 = 0;	// 1의 개수
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0') cnt0++;
			else cnt1++;
		}
		
		cnt0/=2;		// 각각 나온 개수의 절반 날리기
		cnt1/=2;
		
		// 앞에서부터 1을 제거하며 남기기 -> 그래야 사전순에 가까워짐
		StringBuilder sb1 = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '1' && cnt1 > 0) cnt1--;	// 해당 1 제거하기
			else sb1.append(c);
		}
		
		// 뒤에서부터 0 제거하기
		StringBuilder sb2 = new StringBuilder();
		for(int i = sb1.length()-1; i >= 0 ; i--) {
			char c = sb1.charAt(i);
			if(c == '0' && cnt0 > 0) cnt0--;
			else sb2.append(c);
			
		}
		
		System.out.println(sb2.reverse().toString());
	}

}
