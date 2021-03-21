import java.io.*;
import java.util.*;

// BOJ 최소 신장 트리 with Prim
public class boj1197_Prim {
    public static int V, E;
    public static int[] parent;

    public static void kruskal(PriorityQueue<Edge> pq){
        Edge start = pq.poll();
        int ans = start.weight;
        int count = 1;
        union(start.a, start.b);

        while(count != V-1){
            Edge e = pq.poll();

            if(union(e.a, e.b)){
                count++;
                ans += e.weight;
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
        parent = new int[V+1];
        for(int i=1; i<=V; ++i)
            parent[i] = i;

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.weight - e2.weight;
            }
        });
        while(E-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, w));
        }
        if(V == 1){
            System.out.println(0);
            br.close();
            return;
        }

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
