import java.io.*;
import java.util.*;

/*
 * (구) 현재 회사에 있는 모든 사람 구하기
 * */

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set =  new HashSet<>();
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String op = st.nextToken();
			
			if(op.equals("enter")) {
				set.add(name);
			}else set.remove(name);
		}
		
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<>(set);
		Collections.sort(result);
		Collections.reverse(result);
//		Collections.sort(result, Collectionslections.reverseOrder());
		for(String str : result) {
			sb.append(str+"\n");
		}
		
		System.out.println(sb.toString());

	}

}
