import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 연속 수열을 찾아보자
        int start = 0;
        int end = 0;
        int maxLen = 0;         // 최장길이
        int [] cnt = new int[100001];

        while(end < n){
            while(end < n && cnt[arr[end]] + 1 <= k){   // 범위 내 && k번 이내일 경우
                cnt[arr[end]] += 1;
                end++;
            }

            int tmp = end - start;
            maxLen = Math.max(maxLen, tmp);
            cnt[arr[start]]--;
            start++;
        }

        System.out.print(maxLen);
    }
}
