import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;               // 노드 개수
    static int[] nodes;         // 노드 배열
    static boolean[] visited;   // 방문 확인
    static int root;    // 루트 노드 인덱스
    static int reuslt;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 노드의 개수
        nodes = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nodes[i] = Integer.parseInt(st.nextToken());
            if(nodes[i] == -1){
                root = i;
            }
        }

        st = new StringTokenizer(br.readLine());
        int dIndex = Integer.parseInt(st.nextToken());          // 삭제할 노드 인덱스
        delNode(dIndex);

        reuslt = 0;
        countLeafNode(root);

        System.out.println(reuslt);

    }

    static void delNode(int idx){
        nodes[idx] = -2;        // 삭제 한 노드는 -2

        for(int i = 0; i < n; i++){
            if(nodes[i] == idx){
                delNode(i);
            }
        }
    }

    static void countLeafNode(int idx){
        boolean flag = true;
        visited[idx] = true;

        if(nodes[idx] != -2){       // 삭제 되지 않은 경우
            for(int i = 0; i < n; i++){
                if(nodes[i] == idx && !visited[i]){
                    countLeafNode(i);
                    flag = false;
                }
            }
            if(flag){
                reuslt++;
            }
        }
    }
}
