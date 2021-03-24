package Tree;

import java.io.*;
import java.util.*;

// BOJ 1774 우주신과의 교감
public class boj1774 {
    public static int N, M;
    public static int[] parent;
    public static Vertex[] vertices;
    public static boolean[][] visit;
    public static int count = 0;

    public static void kruskal() {
        double sum = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist > o2.dist ? 1 : -1;
            }
        });

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!visit[i][j] && i!=j) {
                    pq.add(new Edge(i, j, calcDist(i, j)));
                }
            }
        }

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (!visit[e.a][e.b])
                if (union(e.a, e.b)) {
                    visit[e.a][e.b] = true;
                    visit[e.b][e.a] = true;
                    count++;
                    sum += e.dist;
                    if (count == N - 1) {
                        System.out.println(String.format("%.2f", sum));
                        return;
                    }
                }
        }
    }

    public static double calcDist(int a, int b) {
        Vertex v1 = vertices[a];
        Vertex v2 = vertices[b];

        return Math.sqrt(Math.pow(((double) v1.x - (double) v2.x), 2) + Math.pow(((double) v1.y - (double) v2.y), 2));
    }

    public static void tunnel(int a, int b) {
        boolean flag = union(a, b);
        if(flag) count++;
        visit[b][a] = true;
        visit[a][b] = true;
    }

    public static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return false;

        parent[pa] = pb;
        return true;
    }

    public static int find(int a) {
        if (a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        vertices = new Vertex[N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; ++i) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            vertices[i] = new Vertex(x, y);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tunnel(a - 1, b - 1);
        }

        kruskal();
        br.close();
    }

    public static class Edge {
        int a, b;
        double dist;

        public Edge(int a, int b, double dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
    }

    public static class Vertex {
        int x, y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
