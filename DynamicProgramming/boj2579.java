package DynamicProgramming;

import java.io.*;

// BOJ 2579 계단 오르기 <동적 계획법1>
public class boj2579 {
    public static int n;
    public static int[] stairs;
    public static int[] dp;
    public static int max = Integer.MIN_VALUE;

    public static void func(){
        for(int i=3; i<n; ++i){
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n];
        dp = new int[n];
        for(int i=0; i<n; ++i)
            stairs[i] = Integer.parseInt(br.readLine());

        if(n>=1) {
            dp[0] = stairs[0];
            if(n==1) {
                System.out.println(dp[n - 1]);
                return;
            }
        }
        if(n>=2){
            dp[1] = stairs[0] + stairs[1];
            if(n==2){
                System.out.println(dp[n-1]);
                return;
            }
        }
        if(n>=3){
            dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
            if(n==3){
                System.out.println(dp[n-1]);
                return;
            }
        }
        func();
        System.out.println(dp[n-1]);
    }
}
