import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < t; tc++) {
			String [] arr = br.readLine().split("");
			Stack<String> stack1 = new Stack<>();
			Stack<String> stack2 = new Stack<>();
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].equals("(")) {
					if(!stack2.isEmpty()) {
						stack2.pop();
					}else {
						stack1.add(arr[i]);
					}
				}else {
					if(!stack1.isEmpty()) {
						stack1.pop();
					}else {
						if(stack2.isEmpty()) {
							stack2.add(arr[i]);
							break;
						}
						stack2.add(arr[i]);
					}
				}
			}
			
			if(!stack1.isEmpty() || !stack2.isEmpty()) {
				sb.append("NO"+"\n");
			}else {
				sb.append("YES"+"\n");
			}
		}
		System.out.println(sb.toString());
	}

}
