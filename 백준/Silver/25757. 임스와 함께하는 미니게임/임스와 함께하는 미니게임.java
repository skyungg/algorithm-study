import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String op = st.nextToken();
		int cnt = 0;
		if(op.equals("Y")) {
			cnt = 1;
		}else if(op.equals("F")) {
			cnt = 2;
		}else if(op.equals("O")) {
			cnt = 3;
		}
		
		HashSet<String> set = new HashSet<>();
		int tmp = 0;
		String name = "";
		int result = 0;
		for(int i = 0; i < n; i++) {
			name = br.readLine();
			if(set.contains(name)) continue;
			else {
				set.add(name);
				tmp++;
				if(cnt == tmp) {
					result++;
					tmp = 0;
				}
			}
		}
		System.out.println(result);
	}

}
