package DFSnBFS;

import java.io.*;
import java.util.*;

// BOJ 2667 단지번호붙이기 <BFS와 BFS>
public class boj2667 {
    public static int[][] map;
    public static boolean[][] visit;
    public static int N;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static ArrayList<Integer> ans;
    public static int sum;

    public static void solution(){
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if(map[i][j] == 1 && !visit[i][j]){
                    dfs(i, j);
                    ans.add(sum);
                    sum = 0;
                }
            }
        }
    }

    public static void dfs(int x, int y){
        visit[x][y] = true;
        sum++;

        for(int i=0; i<4; ++i){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(isValid(xx, yy)){
                dfs(xx, yy);
            }
        }
    }

    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= N)
            return false;
        if(visit[x][y] || map[x][y] == 0)
            return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        ans = new ArrayList<>();
        sum = 0;

        for(int i=0; i<N; ++i){
            String tmp = br.readLine();
            for(int j=0; j<N; ++j){
                map[i][j] = tmp.charAt(j)- '0';
            }
        }
        solution();

        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        for(int i=0; i<ans.size(); ++i)
            sb.append(ans.get(i)).append("\n");
        System.out.println(sb);
        br.close();
    }
}
