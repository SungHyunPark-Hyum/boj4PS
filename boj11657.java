import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// BOJ 11657 타임머신 <최단 경로>
public class boj11657 {
    public static int N, M;
    public static ArrayList<ArrayList<Node>> map;
    public static int[] dist;

    public static void BellmanFord(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int l = 1; l <= N - 1; ++l) {
            for (int i = 1; i <= N; ++i) {
                for (Node e : map.get(i)) {
                    if (dist[i] != Integer.MAX_VALUE) {
                        if (dist[e.dest] > dist[i] + e.time) {
                            dist[e.dest] = dist[i] + e.time;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            for (Node e : map.get(i)) {
                if (dist[i] != Integer.MAX_VALUE) {
                    if (dist[e.dest] > dist[i] + e.time) {
                        sb.append(-1).append("\n");
                        System.out.println(sb);
                        return;
                    }
                }
            }
        }

        for (int i = 2; i <= N; ++i) {
            if (dist[i] == Integer.MAX_VALUE)
                sb.append(-1).append("\n");
            else
                sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i <= N; ++i)
            map.add(new ArrayList<Node>());
        dist = new int[N + 1];
        boolean flag = true;

        for (int l = 0; l < M; ++l) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            for(int i=0; i<map.get(f).size(); ++i){
                if(map.get(f).get(i).dest == t){
                    map.get(f).get(i).time = Math.min(map.get(f).get(i).time, w);
                    flag = false;
                    break;
                }
            }
            if(flag)
                map.get(f).add(new Node(t, w));

            flag = true;
        }

        BellmanFord(1);
        br.close();
    }

    public static class Node {
        int dest, time;

        public Node(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }
}
