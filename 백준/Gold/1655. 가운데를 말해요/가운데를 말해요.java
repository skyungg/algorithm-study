import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(); // 정답
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙 -> 작은숫자~중간값까지, (중간값이 들어있느 heap)
        PriorityQueue<Integer> minPq = new PriorityQueue<>();   // 최소 힙 -> 중간값보다 큰 숫자들

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            // 추가 및 비교하는 로직
            if(minPq.size() == maxPq.size()) maxPq.add(num);
            else minPq.add(num);

            if(!minPq.isEmpty() && !maxPq.isEmpty() && minPq.peek() < maxPq.peek()){
                int tmp = minPq.poll();
                minPq.add(maxPq.poll());
                maxPq.add(tmp);
            }
            // 정답에 추가하는 로직
            sb.append(maxPq.peek()+"\n");
        }
        System.out.println(sb);
    }
}
