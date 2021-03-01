package ShortestPaths;

import java.io.*;
import java.util.*;

// BOJ 1753 최단경로 <최단 경로>
public class boj1753 {
    public static int V, E;
    public static ArrayList<ArrayList<Edge>> map;
    public static int[] answer;
    public static StringBuilder sb = new StringBuilder();

    public static void solution(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        pq.add(new Node(start, 0, start));
        answer[start] = 0;
        boolean[] visit = new boolean[V];

        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(visit[n.num])
                continue;
            else
                visit[n.num] = true;

            for(Edge e : map.get(n.num)){
                if(answer[n.num] + e.w < answer[e.v]){
                    answer[e.v] = answer[n.num] + e.w;
                    pq.add(new Node(e.v, answer[e.v], n.num));
                }
            }
        }

        for(int i=0; i<V; ++i){
            if(answer[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(answer[i]).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        map = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<V; ++i)
            map.add(new ArrayList<Edge>());
        answer = new int[V];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for(int l=0; l<E; ++l){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map.get(f-1).add(new Edge(t-1, w));
        }

        solution(start-1);
        System.out.print(sb);
        br.close();
    }

    public static class Node{
        int num, weight, before;
        public Node(int num, int weight, int before){
            this.num = num;
            this.weight = weight;
            this.before = before;
        }
    }

    public static class Edge{
        int v, w;
        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}
