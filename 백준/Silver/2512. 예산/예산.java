
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        int start = 0;
        int end = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }

        Long m = Long.parseLong(br.readLine());

        int result = 0;
        while(start <= end){
            int mid = (start+end)/2;

            long sum = 0;
            for(int i = 0; i < n ; i++){
                if(arr[i] <= mid){
                    sum += arr[i];
                }else sum += mid;
            }

            if(sum <= m){
                result = Math.max(result, mid);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

}
