import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int [] nums;
	static long maxValue = Long.MIN_VALUE;
	static long minValue = Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		int [] op = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		backtracking(1, nums[0], op);
		
		StringBuilder sb = new StringBuilder();
		sb.append(maxValue+"\n"+minValue);
		System.out.println(sb.toString());
	}
	
	static void backtracking(int index, long curNum, int [] op) {
		// 가지치기
		if (index == n) {
            maxValue = Math.max(maxValue, curNum);
            minValue = Math.min(minValue, curNum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                long next = calculate(curNum, nums[index], i);		// 현재숫자, 그 다음숫자
                backtracking(index + 1, next, op);
                op[i]++; // 원상복구
            }
        }
	}
	
	static long calculate(long a, long b, int op) {
		long answer = 0;
		
		if(op == 0) {
			answer = a+b;
		}else if(op == 1) {
			answer = a-b;
		}else if(op == 2) {
			answer = a*b;
		}else {
			if(a < 0) {
				answer = -(-a/b);
			}else {				
				answer = a/b;
			}
		}
		
		return answer;
	}
}
