import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int [][] arr_a = new int[h][w];         // 배열 a
        int [][] arr_b = new int[h+x][w+y];     // 배열 b
        for(int i = 0; i < h+x; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w+y; j++){
                arr_b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(i >= x && j >= y){
                    arr_a[i][j] = arr_b[i][j] - arr_a[i-x][j-y];
                }else{
                    arr_a[i][j] = arr_b[i][j];
                }
            }
        }

        for(int [] arr : arr_a){
            for(int num : arr){
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }
}
