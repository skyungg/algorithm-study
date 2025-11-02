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
		
		cnt0/=2;
		cnt1/=2;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < cnt0; i++) sb.append('0');
		
		for(int i = 0; i < cnt1; i++) sb.append('1');
		
		System.out.println(sb);
	}

}
