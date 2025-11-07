import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!list.contains(num)) list.add(num);
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int n : list) {
			sb.append(n+" ");
		}
		
		System.out.println(sb);
		
	}

}
