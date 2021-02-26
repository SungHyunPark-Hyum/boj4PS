package DFSnBFS;

import java.io.*;
import java.util.*;

// BOJ 7576 토마토 <DFS와 BFS>
public class boj7576 {
    public static int M, N;
    public static int[][] map;
    public static boolean[][] visit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int answer = 0;
    public static int count = 0;
    public static int count1 = 0;

    public static void bfs(Queue<Node> q){
        while(!q.isEmpty()){
            int loop = q.size();

            for(int i=0; i<loop; ++i){
                Node e = q.poll();
                for(int j=0; j<4; ++j){
                    int x = e.x + dx[j];
                    int y = e.y + dy[j];
                    if(check(x, y)){
                        q.add(new Node(x, y));
                        visit[x][y] = true;
                        count1++;
                    }
                }
            }
            answer++;
        }
    }

    public static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        if(map[x][y] == -1) return false;
        if(visit[x][y]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        Queue<Node> q = new LinkedList<Node>();
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; ++j){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a == 1) {
                    q.add(new Node(i, j));
                    visit[i][j] = true;
                }
                if(a == 0)
                    count++;
            }
        }

        bfs(q);
        if(count == count1)
            System.out.println(answer-1);
        else {
            System.out.println(-1);
        }
    }

    public static class Node{
        public int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
