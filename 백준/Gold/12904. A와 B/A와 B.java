import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        int answer = 0;
        while(s.length() < t.length()){
            if(t.charAt(t.length()-1) == 'A'){
                t = t.substring(0, t.length()-1);
            }else {
                t = t.substring(0, t.length()-1);
                StringBuilder tmp = new StringBuilder(t);
                t = tmp.reverse().toString();
            }
        }

        if(s.equals(t)) answer = 1;

        System.out.println(answer);
    }
}
