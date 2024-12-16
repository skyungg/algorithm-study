import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < t; tc++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			String result = "";
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					stack.add('(');
				}else {
					if(!stack.isEmpty()) {
						stack.pop();
					}else {
						result = "NO";
						break;
					}
				}
			}
			if(result == "") {
				if(!stack.isEmpty()) result = "NO";
				else result = "YES";
			}
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}

}
