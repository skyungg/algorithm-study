import java.io.*;
import java.util.*;

/*
 * 풀이: class 만들지 않고 풀어보기
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Object[]> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int mat = Integer.parseInt(st.nextToken());
			
			list.add(new Object[] {name, kor, eng, mat});
		}
		
		list.sort((a,b) -> {
			String nameA = (String)a[0];
			int korA = (int)a[1];
			int engA = (int)a[2];
			int matA = (int)a[3];
			String nameB = (String)b[0];
			int korB = (int)b[1];
			int engB = (int)b[2];
			int matB = (int)b[3];
			
			if(korA != korB) return korB - korA;		// 국어 내림차순
			if(engA != engB) return engA - engB;		// 영어 오름차순
			if(matA != matB) return matB - matA;		// 수학 내림차순
			return nameA.compareTo(nameB);				// 이름 사전순
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(Object [] ob : list) {
			sb.append((String)ob[0]+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
