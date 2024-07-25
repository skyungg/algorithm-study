
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] aArr;
    static int [] bArr;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        aArr = new int[n];
        bArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< m; i++){
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        int startA = 0;
        int startB = 0;
        int count = 0;
        while(startA < n && startB < m){
            if(aArr[startA] < bArr[startB]){
                sb.append(aArr[startA++] + " ");
            }else{
                sb.append(bArr[startB++] + " ");
            }
        }

        while(startA < n){
            sb.append(aArr[startA++] + " ");
        }while(startB < m){
            sb.append(bArr[startB++] + " ");
        }

        System.out.print(sb);
    }
}
