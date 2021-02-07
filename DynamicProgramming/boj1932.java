package DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 1932 정수 삼각현 <동적 계획법1>
public class boj1932 {
    public static int n;
    public static int[][] map;
    public static int[][] dp;
    public static int max = Integer.MIN_VALUE;

    public static void func(){
        for(int i=1; i<n; ++i){
            for(int j=0; j<i+1; ++j){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + map[i][j];
                    max = Math.max(dp[i][j], max);
                    continue;
                }
                if(j==i){
                    dp[i][j] = dp[i-1][j-1] + map[i][j];
                    max = Math.max(dp[i][j], max);
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + map[i][j];
                max = Math.max(dp[i][j], max);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        dp = new int[n][n];
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; ++j){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
            }
        }
        dp[0][0] = map[0][0];
        func();
        if(n==1) System.out.println(map[0][0]);
        else System.out.println(max);
    }
}
