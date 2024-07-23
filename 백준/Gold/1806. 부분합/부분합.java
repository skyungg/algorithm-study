import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int arr [] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;    // 최대값으로 세팅
        int start = 0;      // 시작
        int end = 0;        // 끝
        int res = 0;     // 합계

        while(true){
            if(res >= s){
                res -= arr[start++];        // 현재 왼쪽 포인터 값 뺀 후, 오른쪽으로 +1이동
                min = Math.min(min, end - start + 1);
            }else if(end == n){
                break;
            }else{
                res += arr[end++];      // 오른쪽 포인터를 오른쪽으로 +1 이동
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.print(0);
        }else{
            System.out.print(min);
        }

    }
}
