import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String [] arr = str.split("-");     // 뺄셈 기준으로 분리하기
        long result = 0;

        for(int i = 0; i < arr.length; i++){
            int tmp = 0;

            String [] num = arr[i].split("\\+");    // 덧셈 기준으로 분리하기

            for(int j = 0; j < num.length; j++){
                tmp += Integer.parseInt(num[j]);
            }
            if(i == 0) result += tmp;
            else result -= tmp;

        }

        System.out.println(result);
        
    }
}
