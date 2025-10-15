import java.io.*;
import java.util.*;

/*
 * (구) 사이트 주소의 비밀번호 찾기
 * 아이디어: map 이용
 * 1. n개의 줄을 입력받으며, key는 사이트주소, value는 비밀번호로 저장한다.
 * 2. 다음 m개의 줄까지 사이트주소를 map에 key값이 존재하는지  보고 출력한다
 * */

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hmap = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pwd = st.nextToken();
			
			hmap.put(site, pwd);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String key = br.readLine();
			sb.append(hmap.get(key)+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
