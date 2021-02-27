package Stack_Queue_Deque;

import java.io.*;
import java.util.*;

// BOJ 1655 가운데를 말해요 <우선순위 큐>
public class boj1655 {
    public static PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> pq2 = new PriorityQueue<>();
    public static StringBuilder sb = new StringBuilder();

    public static void solution(int a, int flag){
        // 1 / 3 . add(1, 2, 3)
        // 2 / 2 . add(1, 2, 3)
        if(flag == 1){
            pq2.add(a);
            pq1.add(pq2.poll());
        }
        // 1, 2 / 2 . add(1, 2, 3)
        // 1, 2 / 4 . add(1, 2, 3, 4)
        else{
            pq1.add(a);
            pq2.add(pq1.poll());
        }
        sb.append(pq1.peek()).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int l=1; l<=N; ++l){
            int a = Integer.parseInt(br.readLine());
            if(l==1) {
                pq1.add(a);
                sb.append(pq1.peek()).append("\n");
                continue;
            }
            solution(a, l%2);
        }
        System.out.print(sb);
        br.close();
    }
}
