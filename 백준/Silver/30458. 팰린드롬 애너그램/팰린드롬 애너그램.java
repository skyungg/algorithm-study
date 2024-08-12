
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String [] arr = br.readLine().split("");

        int check [] = new int[26];

        for(int i = 0; i < n; i++){
            int tmp = arr[i].charAt(0) - 'a';
            check[tmp] += 1;
        }

        if(n%2 == 1){
            int tmp = arr[n/2].charAt(0) - 'a';
            check[tmp] -= 1;
        }

        String result = "Yes";
        for(int i = 0; i < 26; i++){
            if(check[i] % 2 == 1){
                result = "No";
                break;
            }
        }

        System.out.print(result);

    }
}
