import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Long m = Long.parseLong(br.readLine());

        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        long avg = sum/n;

        int start = 1;        // 최솟값
        int end = Arrays.stream(arr).max().getAsInt();          // 최댓값

        long maxAvg = 0;
        long result = 0;
        while(avg >= start && avg <= end){
            long tmp = 0;
            for(int i = 0; i < n ; i++){
                if(arr[i] <= avg){
                    tmp += arr[i];
                }else tmp += avg;
            }

            if(tmp <= m){
                if(maxAvg < tmp){
                    maxAvg = tmp;
                    result = avg;
                    avg++;
                }else break;
            }else{
                avg--;
            }
        }

        System.out.println(result);
    }

}
