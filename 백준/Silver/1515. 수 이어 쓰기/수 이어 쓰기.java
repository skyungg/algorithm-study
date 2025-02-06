/*
 * 아이디어: 구현, 그리디..?
 * */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		int idx = 0;
		int num = 0;
		
		while(idx < nums.length()) {
			num++;		// 자연수를 1부터 시작해서 계속 증가하기
			String str = Integer.toString(num);
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(idx < nums.length() && ch == nums.charAt(idx)) {
					idx++;	// 현재 문자 ch가 구해야하는 nums에 포함되어 있으면 idx 증가
				}
				if(idx >= nums.length()) break;	// 다 찾음
			}
			
		}
		
		System.out.println(num);
		
	}

}
