import java.io.*;
import java.util.*;

// BOJ 4386 별자리 만들기
public class boj4386 {
    public static int n;
    public static int[] parent;

    public static void kruskal(ArrayList<Vertex> vertices){
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.dist > e2.dist ? 1 : -1;
            }
        });

        int len = vertices.size();
        for(int i=0; i<len-1; ++i){
            for(int j=i+1; j<len; ++j){
                pq.add(new Edge(i, j, calcDist(vertices.get(i), vertices.get(j))));
            }
        }

        int count = 0;
        double sum = 0;
        while(count != n-1){
            Edge e = pq.poll();

            if(union(e.a, e.b)){
                count++;
                sum += e.dist;
            }
        }
        System.out.println(Math.round(sum*100)/100.0);
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
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    public static double calcDist(Vertex v1, Vertex v2){
        return Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        parent = new int[n];
        for(int i=0; i<n; ++i){
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            vertices.add(new Vertex(x, y, i));
        }

        kruskal(vertices);
        br.close();
    }

    public static class Edge{
        int a, b; double dist;
        public Edge(int a, int b, double dist){
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
    }

    public static class Vertex{
        double x, y; int num;
        public Vertex(double x, double y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
