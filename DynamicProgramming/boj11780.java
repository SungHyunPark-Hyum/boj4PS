package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 11780 플로이드 2 <Floyd Warshall>
public class boj11780 {
    public static int n, m;
    public static int[][] dist;
    public static int[][] map;
    public static int[][] dp;
    public static StringBuilder sb = new StringBuilder();

    public static void floyd(){
        for(int k=0; k<n; ++k){
            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    int vDist = dist[i][k] + dist[k][j];
                    if(vDist < dist[i][j]) {
                        dist[i][j] = vDist;
                        dp[i][j] = dp[k][j];
                    }
                }
            }
        }

        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    public static void backTracking(int a, int b) {
        if (a == b || dp[a][b] == -1){
            sb.append(0).append("\n");
            return;
        }
        int count = 1;
        Stack<Integer> stk = new Stack<>();
        stk.push(b+1);
        while(dp[a][b] != a){
            b = dp[a][b];
            stk.push(b+1);
            count++;
        }
        count++;
        sb.append(count).append(" ");
        sb.append(a+1).append(" ");
        while(!stk.isEmpty()){
            sb.append(stk.pop()).append(" ");
        }
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        dp = new int[n][n];
        for(int i=0; i<n; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(dp[i], -1);
            dist[i][i] = 0;
        }

        StringTokenizer st;
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(w < dist[a-1][b-1]) {
                dist[a - 1][b - 1] = w;
                dp[a-1][b-1] = a-1;
            }
        }

        floyd();
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                backTracking(i, j);
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
