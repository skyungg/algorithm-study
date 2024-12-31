import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String op = st.nextToken();
		
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		int size = set.size();
		int cnt = 0;
		if(op.equals("Y")) {
			cnt = 1;
		}else if(op.equals("F")) {
			cnt = 2;
		}else if(op.equals("O")) {
			cnt = 3;
		}
		
		System.out.println(size/cnt);
		
	}

}
