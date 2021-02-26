package DFSnBFS;

import java.io.*;
import java.util.*;

// BOJ 2178 미로 탐색 <BFS와 DFS>
public class boj2178 {
    public static int[][] map;
    public static boolean[][] visit;
    public static int N, M;
    public static int answer = Integer.MAX_VALUE;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(x, y, 1));

        while (!q.isEmpty()) {
            Node e = q.poll();
            if (e.x == N - 1 && e.y == M - 1) {
                answer = e.count;
                break;
            }


            for (int i = 0; i < 4; ++i) {
                int px = e.x + dx[i];
                int py = e.y + dy[i];
                if (check(px, py)) {
                    q.add(new Node(px, py, e.count + 1));
                    visit[px][py] = true;
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) return false;
        if (visit[x][y]) return false;
        if (map[x][y] == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            String tmp = br.readLine();
            for (int j = 0; j < M; ++j) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(answer);
    }

    public static class Node {
        public int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
