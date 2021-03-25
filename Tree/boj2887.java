package Tree;

import java.io.*;
import java.util.*;

// BOJ 2887 행성 터널
public class boj2887 {
    public static int[] parent;

    public static void kruskal(PriorityQueue<Edge> pq, int N){
        int sum = 0;
        int count = 0;

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(union(e.a, e.b)){
                sum += e.dist;
                count++;
            }

            if(count == N-1){
                System.out.println(sum);
                return;
            }
        }
    }

    public static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb)
            return false;

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
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        StringTokenizer st;
        ArrayList<Vertex> arr = new ArrayList<>();
        while(N-- > 0){
            parent[N] = N;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arr.add(new Vertex(x, y, z, N));
        }

        N = arr.size();
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });
        Collections.sort(arr, (p1, p2) -> p1.x - p2.x);
        for(int i=0; i<N-1; ++i){
            pq.add(new Edge(arr.get(i).num, arr.get(i+1).num, Math.abs(arr.get(i).x - arr.get(i+1).x)));
        }
        Collections.sort(arr, (p1, p2) -> p1.y - p2.y);
        for(int i=0; i<N-1; ++i){
            pq.add(new Edge(arr.get(i).num, arr.get(i+1).num, Math.abs(arr.get(i).y - arr.get(i+1).y)));
        }
        Collections.sort(arr, (p1, p2) -> p1.z - p2.z);
        for(int i=0; i<N-1; ++i){
            pq.add(new Edge(arr.get(i).num, arr.get(i+1).num, Math.abs(arr.get(i).z - arr.get(i+1).z)));
        }

        kruskal(pq, N);
        br.close();
    }

    public static class Edge{
        int a, b, dist;
        public Edge(int a, int b, int dist){
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
    }

    public static class Vertex{
        int x, y, z, num;
        public Vertex(int x, int y, int z, int num){
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }
    }
}
