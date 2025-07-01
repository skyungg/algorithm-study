import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long W = Long.parseLong(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		
		// 1. 평행이동만 할 경우
		long dis1 = (X+Y)*W;
		
		// 2. 대각선 이동만 할 경우
		long dis2 = 0;
		if((X+Y)%2 == 0) dis2 = Math.max(X, Y)*S;
		else dis2 = (Math.max(X, Y)-1)*S + W;
		
		// 3. 반반 섞기
		long dis3 = (Math.min(X, Y))*S + (Math.abs(X-Y))*W;
		
		System.out.println(Math.min(Math.min(dis1, dis2), dis3));

	}

}
