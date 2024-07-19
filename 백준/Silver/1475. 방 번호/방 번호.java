
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int setNum[];

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int [] nums = new int[str.length()];

        for(int i = 0; i < str.length(); i++){
            int tmp = Integer.parseInt(Character.toString(str.charAt(i)));
            nums[i] = tmp;
            if(tmp == 9){
                nums[i] = 6;
            }
        }

        int count = 1;  // 세트 수 (초기 1세트)
        setNum = new int[10];
        Arrays.fill(setNum, 1);     // 1로 초기화
        setNum[6] += 1;

        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(setNum[cur] > 0){
                setNum[cur] -= 1;
            }else{
                reFill();
                count++;
                setNum[cur] -= 1;

            }
        }

        System.out.println(count);

    }

    static void reFill(){
        for(int i = 0; i < setNum.length; i++){
            setNum[i] += 1;
        }
        setNum[6] += 1;
    }
}
