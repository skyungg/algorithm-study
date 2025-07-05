import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		System.out.println(A+B-C);
		StringBuilder sb = new StringBuilder();
		sb.append(A+""+B);
		int sum = Integer.parseInt(sb.toString());
		System.out.println(sum - C);
		

	}

}
