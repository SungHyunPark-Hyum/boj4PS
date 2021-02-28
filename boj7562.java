import java.io.*;
import java.util.*;

// BOJ 7562 나이트의 이동 <DFS와 BFS>
public class boj7562 {
    public static int[][] map;
    public static boolean[][] visit;
    public static int I;
    public static int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static StringBuilder sb = new StringBuilder();

    public static void solution(Node s, int tx, int ty){
        Queue<Node> q = new LinkedList<>();
        q.add(s);
        int ans = 0;

        while(!q.isEmpty()){
            Node e = q.poll();
            int nx = e.x;
            int ny = e.y;
            if(nx == tx && ny == ty){
                ans = e.count;
                sb.append(ans).append("\n");
                return;
            }

            for(int i=0; i<8; ++i){
                int xx = nx + dx[i];
                int yy = ny + dy[i];
                if(check(xx, yy)){
                    q.add(new Node(xx, yy, e.count+1));
                    visit[xx][yy] = true;
                }
            }
        }
    }

    public static boolean check(int x, int y){
        if(x < 0 || y < 0 || x > I-1 || y > I-1)
            return false;
        if(visit[x][y])
            return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int l=0; l<T; ++l){
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visit = new boolean[I][I];
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            solution(new Node(sx, sy, 0), tx, ty);
        }
        System.out.println(sb);
        br.close();
    }

    public static class Node{
        int x, y, count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
