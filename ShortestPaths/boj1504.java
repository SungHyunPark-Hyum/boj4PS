package ShortestPaths;

import java.io.*;
import java.util.*;

// BOJ 1504 특정한 최단 경로 <최단 경로>
public class boj1504 {
    public static int N, E;
    public static int[][] map;
    public static int[] dist;
    public static boolean[] visit;

    public static int dijkstra(int start, int end){
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visit = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node e = pq.poll();

            if(visit[e.num])
                continue;
            else
                visit[e.num] = true;
            if(e.num == end){
                return dist[end];
            }

            for(int i=0; i<N; ++i){
                if(map[e.num][i] != 0){
                    if(dist[e.num] + map[e.num][i] < dist[i]){
                        dist[i] = dist[e.num] + map[e.num][i];
                        pq.add(new Node(i, dist[i]));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int l=0; l<E; ++l){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[v1-1][v2-1] = map[v2-1][v1-1] = w;
        }
        st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken()) - 1;
        int t2 = Integer.parseInt(st.nextToken()) - 1;

        int a3 = dijkstra(t1, t2);
        if(a3 == -1){
            System.out.println(-1);
            return;
        }

        int a1, a2, a4, a5;
        int ret1, ret2;
        a1 = dijkstra(0, t1);
        if(a1 == -1){
            ret1 = -1;
        }
        else{
            a5 = dijkstra(t2, N-1);
            if(a5 == -1){
                ret1 = -1;
            }
            else{
                ret1 = a1 + a3 + a5;
            }
        }

        a2 = dijkstra(0, t2);
        if(a2 == -1){
            ret2 = -1;
        }
        else{
            a4 = dijkstra(t1, N-1);
            if(a4 == -1){
                ret2 = -1;
            }
            else{
                ret2 = a2 + a3 + a4;
            }
        }
        System.out.println(Math.min(ret1, ret2));
    }

    public static class Node{
        int num, weight;
        public Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
}
