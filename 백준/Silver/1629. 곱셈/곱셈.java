import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long result = 1;
		
		if(A > C) A = A%C;
		
		while(true) {
			if(B == 1) break;
			
			if(B%2 == 1) {
				result = (result*A)%C;
				B--;
			}
			
			A = (A*A)%C;
			B /= 2;
		}
		
		result = (result*A)%C;
		
		System.out.println(result);
	}

}
