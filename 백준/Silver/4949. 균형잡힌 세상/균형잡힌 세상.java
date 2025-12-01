import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) break;
			
			String [] arr = str.split(" ");
			
			Stack<Character> stack = new Stack<>();
			
			boolean flag = true;
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length(); j++) {
					if(arr[i].charAt(j) == '(') {
						stack.add('(');
					}else if(arr[i].charAt(j) == '[') {
						stack.add('[');
					}else if(arr[i].charAt(j) == ')') {
						if(stack.isEmpty() || stack.peek() != '(') {		// "()"조건 만족 X
							flag = false;
							break;
						}
						stack.pop();
					}else if(arr[i].charAt(j) == ']') {
						if(stack.isEmpty() || stack.peek() != '[') {		// "[]" 조건 만족 X
							flag = false;
							break;
						}
						stack.pop();
					}
				}
				if(!flag) break;
			}
			
			if(!flag) sb.append("no"+"\n");
			else {
				if(!stack.isEmpty()) sb.append("no"+"\n");
				else sb.append("yes"+"\n");
			}
		}
		
		// 결과 출력
		System.out.println(sb);

	}

}
