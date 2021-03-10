package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 12852 1로 만들기 2 <동적 계획법과 최단거리 역추적>
public class boj12852 {
    public static int N;
    public static int[] dp;
    public static int[] back;
    public static StringBuilder sb = new StringBuilder();

    public static void solution(int n) {
        for(int i=4; i<=n; ++i){
            dp[i] = dp[i-1] + 1;
            back[i] = i-1;
            if(i%2 == 0){
                if(dp[i/2] + 1 <= dp[i]){
                    dp[i] = dp[i/2] + 1;
                    back[i] = i/2;
                }
            }
            if(i%3 == 0){
                if(dp[i/3] + 1 <= dp[i]){
                    dp[i] = dp[i/3] + 1;
                    back[i] = i/3;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        back = new int[N + 1];

        if(N>=2){
            dp[2] = 1; back[2] = 1;
        }
        if(N>=3){
            dp[3] = 1; back[3] = 1;
        }
        solution(N);

        sb.append(dp[N]).append("\n");
        while(N != 0){
            sb.append(N).append(" ");
            N = back[N];
        }
        System.out.println(sb);
        br.close();
    }
}
