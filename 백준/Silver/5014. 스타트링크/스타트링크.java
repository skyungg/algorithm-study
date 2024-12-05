import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());       // 총 층
        int s = Integer.parseInt(st.nextToken());       // 시작 층
        int g = Integer.parseInt(st.nextToken());       // 목표 층
        int u = Integer.parseInt(st.nextToken());       // 한 번에 올라가는 층
        int d = Integer.parseInt(st.nextToken());       // 한 번에 내려가는 층

        if(s == g){
            System.out.println(0);
            return;
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        int [] tmp = new int[2];
        int [] visited = new int[f+1];

        int count = -1;
        visited[s] = 1;
        while(!que.isEmpty()){
            int point = que.poll();

            if(point == g){
                count = visited[g] - 1;
                break;
            }

            tmp[0] = point+u;
            tmp[1] = point-d;

            for(int i = 0; i < 2; i++){
                if(tmp[i] > 0 && tmp[i] <= f && visited[tmp[i]] == 0){
                    visited[tmp[i]] = visited[point] + 1;
                    que.add(tmp[i]);
                }
            }
        }

        if(count != -1)System.out.println(count);
        else System.out.println("use the stairs");
    }
}
