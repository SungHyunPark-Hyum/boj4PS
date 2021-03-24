package Tree;

import java.io.*;
        import java.util.*;

// BOJ 17472 다리 만들기 2
public class boj17472 {
    public static int N, M;
    public static int[][] map;
    public static boolean[][] visit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[] parent;
    public static PriorityQueue<Edge> pq;
    public static int num;

    public static void kruskal(){
        int sum = 0;
        int count = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(union(e.a, e.b)){
                sum += e.dist;
                count++;
            }

            if(count == num-2) {
                System.out.println(sum);
                return;
            }
        }

        System.out.println(-1);
        return;
    }

    public static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) {
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

    public static void setNeighbor(int x, int y) {
        num = 1;
        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                if(!visit[i][j]){
                    dfs(i, j, num++);
                }
            }
        }
    }

    public static void dfs(int x, int y, int num){
        visit[x][y] = true;
        map[x][y] = num;

        for(int i=0; i<4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(check(nx, ny)){
                dfs(nx, ny, num);
            }
        }
    }

    public static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        if(visit[x][y]) return false;
        return true;
    }

    public static void getDist(){
        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                if(map[i][j] == 0) continue;

                int[] ret1 = calcDist1(i, j);
                int[] ret2 = calcDist2(i, j);
                if(ret1[0] == map[i][j]){}
                else
                    pq.add(new Edge(map[i][j], ret1[0], ret1[1]));
                if(ret2[0] == map[i][j]) continue;
                else
                    pq.add(new Edge(map[i][j], ret2[0], ret2[1]));
            }
        }
    }

    public static int[] calcDist1(int x, int y){
        int[] ret = new int[2];
        int flag = map[x][y];
        ret[0] = map[x][y];
        ret[1] = 0;
        while(++y < M){
            if(map[x][y] == 0)
                ret[1]++;
            else if(map[x][y] == flag)
                return ret;
            else {
                if(ret[1] < 2)
                    return ret;
                ret[0] = map[x][y];
                return ret;
            }
        }
        return ret;
    }

    public static int[] calcDist2(int x, int y){
        int[] ret = new int[2];
        int flag = map[x][y];
        ret[0] = map[x][y];
        ret[1] = 0;
        while(++x < N){
            if(map[x][y] == 0)
                ret[1]++;
            else if(map[x][y] == flag)
                return ret;
            else {
                if(ret[1] < 2)
                    return ret;
                ret[0] = map[x][y];
                return ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0)
                    visit[i][j] = true;
            }
        }
        setNeighbor(0, 0);
        parent = new int[num];
        parent[num-1] = num-1;
        for(int i=0; i<num; ++i)
            parent[i] = i;

        getDist();
        kruskal();
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
}
