package Stack_Queue_Deque;

import java.io.*;
import java.util.*;

// BOJ 11279 최소 힙 <우선순위 큐>
public class boj1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; ++i){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if(!pq.isEmpty()) {
                    int ans = pq.poll();
                    sb.append(ans).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else{
                pq.add(a);
            }
        }
        System.out.println(sb);
        br.close();
    }
}
