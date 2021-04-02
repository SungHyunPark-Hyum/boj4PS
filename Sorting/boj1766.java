package Sorting;

import java.io.*;
import java.util.*;

// BOJ 1766 문제집
public class boj1766 {
    public static int N, M;
    public static ArrayList<Integer>[] tree;

    public static void solution(int N, int[] indegree){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.order == o2.order)
                    return o1.num - o2.num;
                return o1.order - o2.order;
            }
        });
        int order = 0;
        for(int i=1; i<=N; ++i)
            if(indegree[i] == 0){
                pq.add(new Node(i, order++));
            }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Node e = pq.poll();
            sb.append(e.num).append(" ");

            for(Integer child : tree[e.num]){
                if(--indegree[child] == 0){
                    pq.add(new Node(child, e.order));
                }
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N+1];
        tree = new ArrayList[N+1];
        for(int i=0; i<=N; ++i)
            tree[i] = new ArrayList<>();

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            indegree[a]++;
            tree[b].add(a);
        }

        solution(N, indegree);
        br.close();
    }

    public static class Node{
        int num, order;
        public Node(int num, int order){
            this.num = num;
            this.order = order;
        }
    }
}
