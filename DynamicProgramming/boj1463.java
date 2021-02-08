package DynamicProgramming;

import java.io.*;

// BOJ 1463 1로 만들기 <동적 계획법>
public class boj1463 {
    public static int N;
    public static int[] dp;

    public static void func(int n){
        for(int i=4; i<=n; ++i){
            int min = dp[i-1];
            if(i%3==0 && i%2==0){
                dp[i] = Math.min(Math.min(dp[i/3], dp[i/2]), min) + 1;
                continue;
            }
            else if(i%3==0 && i%2!=0){
                dp[i] = Math.min(dp[i/3], min) + 1;
                continue;
            }
            else if(i%3!=0 && i%2==0){
                dp[i] = Math.min(dp[i/2], min) + 1;
                continue;
            }
            dp[i] = dp[i-1] + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1] = 0;
        if(N>=2){
            dp[2] = 1;
        }
        if(N>=3){
            dp[3] = 1;
        }
        func(N);
        System.out.println(dp[N]);
    }
}
