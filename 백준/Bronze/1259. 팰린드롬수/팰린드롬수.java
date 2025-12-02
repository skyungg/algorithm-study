import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String num = br.readLine();
			if(num.equals("0")) break;
			
			int numLength = num.length();
			boolean flag = true;
			if(numLength%2 == 0) {		// 짝수 길이
				for(int i = 0; i < numLength/2; i++) {
					if(num.charAt(i) != num.charAt(numLength-1-i)) {
						flag = false;
						sb.append("no"+"\n");
						break;
					}
				}
				if(flag) sb.append("yes"+"\n");
			}else {							// 홀수 길이
				for(int i = 0; i < numLength/2; i++) {
					if(num.charAt(i) != num.charAt(numLength-1-i)) {
						flag = false;
						sb.append("no"+"\n");
						break;
					}
				}
				if(flag) sb.append("yes"+"\n");
			}
		}
		
		// 정답 출력 
		System.out.println(sb);

	}

}
