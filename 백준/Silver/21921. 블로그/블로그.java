
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, x;
    static int arr [];
    static int sumArr [];
    static int maxVisited;
    static int count;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        sumArr = new int[n+1];
        int sum = Integer.parseInt(st.nextToken());
        int cur = 0;
        sumArr[cur++] = 0;
        sumArr[cur++] = sum;
        for(int i = 1; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            sumArr[cur] = sumArr[cur-1] + tmp;
            sum += tmp;
            cur++;
        }

        if(sum == 0){
            System.out.print("SAD");
        }else{
            solution();
            System.out.println(maxVisited);
            System.out.print(count);
        }
    }

    static void solution(){
        int start = 0;
        int end = x;

        maxVisited = 0;
        count = 1;

        while(end <= n){
            int sum = 0;
            sum = sumArr[end] - sumArr[start];

            if(maxVisited == sum){
                count++;
            }else{
                if(sum > maxVisited){
                    maxVisited = sum;
                    count = 1;          // 갱신되는 순간, 초기값은 1
                }
            }

            start++;
            end++;

        }
    }
}
