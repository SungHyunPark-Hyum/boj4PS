package DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 1912 연속합 <동적 계획법>
public class boj1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        int max = arr[0];
        dp[0] = arr[0];
        for(int i=1; i<n; ++i) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = max > dp[i] ? max : dp[i];
        }
        System.out.println(max);
    }
}
