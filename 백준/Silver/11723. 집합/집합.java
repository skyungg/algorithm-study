import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> tmp = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
			11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			if(op.equals("add")){
				int n = Integer.parseInt(st.nextToken());
				if(!set.contains(n)) set.add(n);
				
			}else if(op.equals("remove")){
				int n = Integer.parseInt(st.nextToken());
				if(set.contains(n)) set.remove(n);
				
			}else if(op.equals("check")){
				int n = Integer.parseInt(st.nextToken());
				if(set.contains(n)) sb.append("1\n");
				else sb.append("0\n");
				
			}else if(op.equals("toggle")){
				int n = Integer.parseInt(st.nextToken());
				if(set.contains(n)) set.remove(n);
				else set.add(n);
				
			}else if(op.equals("all")){
				set.clear();
				set.addAll(tmp);
			}else if(op.equals("empty")){
				set.clear();
			}
		}
		System.out.println(sb.toString());
	}

}
