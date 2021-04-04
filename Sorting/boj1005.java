package Sorting;

import java.io.*;
import java.util.*;

// BOJ ACM Craft
public class boj1005 {
    public static int[] time;
    public static int[] indegree;
    public static ArrayList<Integer>[] bridge;
    public static PriorityQueue<Node> pq;

    public static void solution(int target){
        int answer = 0;

        while(!pq.isEmpty()){
            Node e = pq.poll();
            answer += e.time;
            if(e.num == target){
                break;
            }
            ArrayList<Node> tmp = new ArrayList<>();
            while(!pq.isEmpty()){
                Node nmp = pq.poll();
                tmp.add(new Node(nmp.num, nmp.time - e.time));
            }
            for(Node ee : tmp)
                pq.add(ee);

            for(Integer child : bridge[e.num]){
                indegree[child]--;

                if(indegree[child]==0){
                    pq.add(new Node(child, time[child]));
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            time = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; ++i){
                time[i] = Integer.parseInt(st.nextToken());
            }

            indegree = new int[N+1];
            bridge = new ArrayList[N+1];
            for(int i=1; i<=N; ++i) {
                bridge[i] = new ArrayList<>();
            }
            while(K-- > 0){
                st = new StringTokenizer(br.readLine());
                int b = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                bridge[b].add(a);
                indegree[a]++;
            }

            int target = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.time - o2.time;
                }
            });
            for(int i=1; i<=N; ++i){
                if(indegree[i] == 0)
                    pq.add(new Node(i, time[i]));
            }

            solution(target);
        }
    }

    public static class Node{
        int num, time;
        public Node(int num, int time){
            this.num = num;
            this.time = time;
        }
    }
}