package Stack_Queue_Deque;

import java.io.*;
import java.util.*;

// BOJ 11286 절댓값 힙 <우선순위 큐>
public class boj11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node e1, Node e2){
                return e1.absolute != e2.absolute ? e1.absolute - e2.absolute : e1.real - e2.real;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; ++i){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if(!pq.isEmpty()) {
                    Node ans = pq.poll();
                    sb.append(ans.real).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else{
                pq.add(new Node(Math.abs(a), a));
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static class Node{
        public int absolute, real;
        public Node(int a, int r){
            this.absolute = a;
            this.real = r;
        }
    }
}
