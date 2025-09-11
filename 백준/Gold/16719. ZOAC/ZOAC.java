import java.io.*;
import java.util.*;

/*
 * 아이디어: 구현
 * 1. 
 * */
public class Main {
	static char [] arr;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		visited = new boolean[arr.length];
		start(0, arr.length-1);	
		System.out.println(sb.toString());

	}
	
	static void start(int left, int right) {
		if(left > right) return;
		
		// 1.  현재 구간에서 사전순 최소 문자 찾기
		int mid = left;
		for(int i = left; i <= right; i++) {
			if(arr[i] < arr[mid]) mid = i;
		}
		
		// 2. 방문 처리
		visited[mid] = true;
		
		// 3. 현재까지 방문된 문자 출력하기
		for(int i = 0; i < arr.length; i++) {
			if(visited[i]) sb.append(arr[i]);
		}
		sb.append("\n");	// 한 줄 띄기
		
		// 4. 재귀
		start(mid+1, right);
		start(left, mid-1);
		
		
	}

}
