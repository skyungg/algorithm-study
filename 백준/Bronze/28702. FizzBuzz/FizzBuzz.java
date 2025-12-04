import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = 0;
		
		for(int i = 0; i < 3; i++) {
			String str = br.readLine();
			
			if(Character.isDigit(str.charAt(0))) {		// 숫자인 경우
				int num = Integer.parseInt(str);
				result = num+(3-i);
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(result %15 == 0) sb.append("FizzBuzz");
		else if(result%3 == 0) sb.append("Fizz");
		else if(result%5 == 0) sb.append("Buzz"); 
		else sb.append(result);
		
		// 결과 출력
		System.out.println(sb);

	}

}
