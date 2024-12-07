import java.io.*;
import java.util.*;

public class Main {
    static int [][] arr = new int[4][8];       // 길이 두 배인 배열
    static int [] status;   // 각 톱니의 회전 상태
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 받기
        for(int i = 0; i < 4; i++){
            String tmp = br.readLine();
            for(int j = 0; j < 8; j++){
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }
        int tc = Integer.parseInt(br.readLine());
        // 2. 회전하기
        for(int i = 0; i < tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int direction = Integer.parseInt(st.nextToken());

            status = new int[4];    // 배열 재할당
            status[num] = direction;
            checkDirection(num);       // 톱니 방향 검사
            rotate();   // 회전하기
        }

        // 3. 점수 산출하기 ( 12시 방향 톱니 -> index가 0 / 어차피 0에 점수 곱해도 0)
        int score = arr[0][0] + (arr[1][0]*2) + (arr[2][0]*4) + (arr[3][0]*8);
        System.out.println(score);
    }

    static void checkDirection(int num){
        // 1. 0번 톱니부터 num 톱니까지
        for(int i = num-1; i >= 0; i--){
            if(arr[i][2] != arr[i+1][6]){
                status[i] = -status[i+1];
            }else break;    // 회전 안 하면 그 다음도 안 함.
        }
        // 2. num+1부터 4번 톱니까지
        for(int i = num+1; i < 4; i++){
            if(arr[i-1][2] != arr[i][6]){
                status[i] = -status[i-1];
            }else break;    // 회전 안하면 그 다음도 회전 안 함.
        }
    }

    static void rotate(){
        int tmp = 0;
        // status의 상태에 따라 톱니 반시계, 시계 회전
        for(int i = 0; i < 4; i++){
            if(status[i] == 1){
                // 맨 뒤 -> 맨 앞
                tmp = arr[i][7];
                for(int j = 7; j > 0; j--){
                    arr[i][j] = arr[i][j-1];
                }
                arr[i][0] = tmp;
            }else if(status[i] == -1){
                // 맨 앞 -> 맨 뒤
                tmp = arr[i][0];
                for(int j = 0; j < 7; j++){
                    arr[i][j] = arr[i][j+1];
                }
                arr[i][7] = tmp;
            }
        }
    }
}
