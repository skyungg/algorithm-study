import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long budget = 5*(long) Math.pow(10, 6);

		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int cost = 0;	// 초기값
			
			long sum = 0;	// 현재 라운드 땅값
			
			List<Integer> list = new ArrayList<>();
			while(true) {
				cost = Integer.parseInt(br.readLine());
				if(cost == 0) break;
				list.add(cost);
			}
			
			// 내림차순 정렬하기
			Collections.sort(list, Collections.reverseOrder());
			
			for(int i = 0; i < list.size(); i++){
				sum += 2* (long) Math.pow(list.get(i), (i+1));
				if(sum > budget) break;		// 예산 초과
			}
			
			if(sum > budget) sb.append("Too expensive"+"\n");
			else sb.append(sum+"\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}
