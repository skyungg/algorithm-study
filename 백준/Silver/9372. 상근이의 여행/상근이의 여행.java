import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());       // 테스트 케이스 수

        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());       // 국가 수
            int m = Integer.parseInt(st.nextToken());       // 비행기 수

            System.out.println(n-1);

            for(int i = 0; i < m; i++){
                br.readLine();
            }
        }

    }
}
