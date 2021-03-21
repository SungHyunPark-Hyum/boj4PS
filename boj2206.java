import java.io.*;
import java.util.*;

// BOJ 2206
public class boj2206 {
    public static int N, M;
    public static char[][] map;
    public static int[][] visit;
    public static int[] dx = { -1, 0, 0, 1 };
    public static int[] dy = { 0, -1, 1, 0 };
    public static int ans = Integer.MAX_VALUE;

    public static void bfs(){
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, 0, 1, false));
        visit[0][0] = 1;

        while(!q.isEmpty()){
            Node e = q.poll();
            if(e.x == N-1 && e.y == M-1){
                ans = Math.min(ans, e.count);
            }

            for(int i=0; i<4; ++i){
                int nx = e.x + dx[i];
                int ny = e.y + dy[i];
                if(isPossible(nx, ny, e.count+1, e.drilled)){
                    if(!e.drilled && map[nx][ny] == '1')
                        q.add(new Node(nx, ny, e.count+1, true));
                    else
                        q.add(new Node(nx, ny, e.count+1, e.drilled));
                }
            }
        }


        System.out.println("visit");
        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    public static boolean isPossible(int x, int y, int count, boolean drilled){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        if(visit[x][y] == 0) {
            if(map[x][y] == '1'){
                if (drilled) {
                    return false;
                }
                else{
                    visit[x][y] = -count;
                    return true;
                }
            }
            else{
                if(drilled){
                    visit[x][y] = -count;
                    return false;
                }
                else{
                    visit[x][y] = count;
                    return true;
                }
            }
        }
        else if(visit[x][y] > 0)
            return false;
        // if(visit[x][y] < 0)
        else {
            if(!drilled) {
                if(-1 * visit[x][y] >= count) {
                    visit[x][y] = count;
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new int[N][M];

        for(int i=0; i<N; ++i){
            String str = br.readLine();
            for(int j=0; j<M; ++j){
                map[i][j] = str.charAt(j);
            }
        }

        bfs();
        br.close();
    }

    public static class Node{
        int x, y, count;
        boolean drilled;
        public Node(int x, int y, int count, boolean drilled){
            this.x = x;
            this.y = y;
            this.count = count;
            this.drilled = drilled;
        }
    }
}
