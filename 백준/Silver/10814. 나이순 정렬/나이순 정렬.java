import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int age;
		String name;
		int idx;
		
		public Point(int age, String name, int idx){
			this.age = age;
			this.name = name;
			this.idx = idx;
		}
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Point> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name= st.nextToken();
			list.add(new Point(age, name, i));
		}
		
		// 정렬
		Collections.sort(list, (a,b) ->{
			if(a.age == b.age) return a.idx - b.idx;
			else return a.age - b.age;
		});
		
		StringBuilder sb = new StringBuilder();
		for(Point p : list) {
			sb.append(p.age+" "+p.name+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
