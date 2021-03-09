package DynamicProgramming;

import java.io.*;

// BOJ 10844 쉬운 계단 수 <동적 계획법>
// not yet, will try later
public class boj10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        dp[1][0] = 0;
        for(int i=1; i<10; ++i)
            dp[1][i] = 1;

        for(int i=2; i<=N; ++i){
            dp[i][0] = dp[i-1][1] % 1000000000;
            for(int j=1; j<9; ++j){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % 1000000000;
            }
            dp[i][9] = dp[i-1][8] % 1000000000;
        }

        long ans = 0;
        for(int i=0; i<10; ++i){
            ans += dp[N][i];
            ans %= 1000000000;
        }
        System.out.println(ans);
        br.close();
    }
}
