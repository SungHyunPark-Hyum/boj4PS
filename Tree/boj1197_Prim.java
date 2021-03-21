package Tree;

import java.io.*;
import java.util.*;

// BOJ 최소 신장 트리 with Prim
public class boj1197_Prim {
    public static int V, E;
    public static int[] parent;
    public static ArrayList<Edge>[] arr;
    public static boolean[][] visit;

    public static void prim(int a, int b, int w){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.weight - e2.weight;
            }
        });
        pq.add(new Edge(a, b ,w));
        int ans = 0;
        int count = 0;

        while(count != V-1){
            Edge e = pq.poll();

            if(union(e.a, e.b)){
                visit[e.a][e.b] = true;
                visit[e.b][e.a] = true;
                count++;
                ans += e.weight;
                for(Edge ne : arr[e.a]){
                    if(!visit[ne.a][ne.b]){
                        visit[ne.a][ne.b] = true;
                        visit[ne.b][ne.a] = true;
                        pq.add(new Edge(ne.a, ne.b, ne.weight));
                    }
                }
                for(Edge ne : arr[e.b]){
                    visit[ne.a][ne.b] = true;
                    visit[ne.b][ne.a] = true;
                    pq.add(new Edge(ne.a, ne.b, ne.weight));
                }
            }
        }

        System.out.println(ans);
    }

    public static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb){
            return false;
        }

        parent[pa] = pb;
        return true;
    }

    public static int find(int a){
        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visit = new boolean[V+1][V+1];
        arr = new ArrayList[V+1];
        for(int i=1; i<=V; ++i)
            arr[i] = new ArrayList<Edge>();
        parent = new int[V+1];
        for(int i=1; i<=V; ++i)
            parent[i] = i;


        int aa = 0, bb = 0, ww = Integer.MAX_VALUE;
        while(E-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[a].add(new Edge(a, b, w));
            arr[b].add(new Edge(b, a, w));
            if(w < ww){
                aa = a; bb = b; ww = w;
            }
        }
        if(V == 1){
            System.out.println(0);
            br.close();
            return;
        }

        prim(aa, bb, ww);
        br.close();
        return;
    }

    public static class Edge{
        int a, b, weight;
        public Edge(int a, int b, int weight){
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }
}
