package DynamicProgramming;

import java.io.*;

// BOJ 2156 포도주 시식 <동적 계획법 1>
public class boj2156 {
    public static int max = Integer.MIN_VALUE;
    public static int n;
    public static int[] wines;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wines = new int[n];
        dp = new int[n];
        for(int i=0; i<n; ++i){
            wines[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = wines[0];
        max = dp[0];
        if(n>=2){
            dp[1] = dp[0] + wines[1];
            max = Math.max(dp[1], max);
        }
        if(n>=3){
            dp[2] = Math.max(wines[0] + wines[2], wines[1] + wines[2]);
            max = Math.max(dp[2], max);
        }
        if(n>=4){
            dp[3] = Math.max(dp[1] + wines[3], dp[0] + wines[2] + wines[3]);
            max = Math.max(dp[3], max);
        }

        for(int i=4; i<n; ++i){
            int cand1 = dp[i-3] + wines[i-1];
            int cand2 = dp[i-2];
            int cand3 = dp[i-4] + wines[i-1];
            dp[i] = Math.max(Math.max(cand1, cand2), cand3) + wines[i];
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
