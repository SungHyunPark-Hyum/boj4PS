package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 1003 피보나치 함수 <동적 계획법 1>.
public class boj1003 {
    public static int[][] dp;

    public static int[] func(int n){
        if(n==0 || n==1){
            return dp[n];
        }

        if(dp[n][0] == 0){
            dp[n][0] = func(n-1)[0] + func(n-2)[0];
            dp[n][1] = func(n-1)[1] + func(n-2)[1];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[41][2];
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        func(40);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; ++i){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
