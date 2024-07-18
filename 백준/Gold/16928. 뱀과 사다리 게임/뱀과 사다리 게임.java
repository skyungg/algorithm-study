
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] map = new int[101];       // 지도
    static boolean[] visited = new boolean[101];       // 방문 확인

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 사다리
        int m = Integer.parseInt(st.nextToken());   // 뱀

        for(int i = 0; i < n+m; i++){
            st = new StringTokenizer(br.readLine());
            int curNum = Integer.parseInt(st.nextToken());
            int nextNum = Integer.parseInt(st.nextToken());
            map[curNum] = nextNum;          // 위치 표시
        }

        bfs();  // 뱀있는
    }
    
    static void bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.add(1);         // 1번부터 시작
        visited[1] = true;

        int count = 0;

        while(!que.isEmpty()){
            int size = que.size();

            for(int x = 0; x < size; x++){
                int num = que.poll();

                if(num == 100){                 // 100번째 도착시 끝
                    System.out.print(count);
                    return;
                }

                for(int i = 1; i <= 6; i++){
                    if(num + i <= 100){                 // 이동할 위치가 100 이하여야 가능
                        int nextNum = num + i;

                        if(map[nextNum] > 0){           // 사다리 or 뱀일경우
                            nextNum = map[nextNum];     // 사다리 or 뱀 타고 이동한 위치가 다음 위치
                        }

                        if(!visited[nextNum]){
                            visited[nextNum] = true;
                            que.add(nextNum);
                        }
                    }
                }
            }

            count++;
        }
    }
}
