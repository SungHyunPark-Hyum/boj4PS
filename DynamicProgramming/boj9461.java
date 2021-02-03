import java.io.*;

// BOJ 9461 파도반 수열 <동적 계획법 1>
public class boj9461 {
    public static long[] dp = new long[101];
    public static int ex_idx = 10;
    public static StringBuilder sb = new StringBuilder();

    public static void func(int n) {
        if (n < ex_idx) {
            sb.append(dp[n]).append("\n");
            return;
        }
        for (int i = ex_idx+1; i <= n; ++i) {
            dp[i] = dp[i-1] + dp[i-5];
        }
        ex_idx = n;
        sb.append(dp[n]).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp[1] = 1; dp[2] = 1; dp[3] = 1;
        dp[4] = 2; dp[5] = 2; dp[6] = 3;
        dp[7] = 4; dp[8] = 5; dp[9] = 7;
        dp[10] = 9;
        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine());
            func(n);
        }
        System.out.println(sb);
        br.close();
    }
}
