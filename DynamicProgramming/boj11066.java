package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOj 11066 파일 합치기
public class boj11066 {
    public static StringBuilder sb = new StringBuilder();

    public static void solution(int[] chapters, int[] sum, int K) {
        int[][] dp = new int[K][K];
        int[][] kp = new int[K][K];
        for (int i = 0; i < K - 1; ++i) {
            dp[i][i + 1] = chapters[i] + chapters[i+1];
            kp[i][i + 1] = i;
        }

        for (int gap = 2; gap < K; ++gap) {
            for (int i = 0; i < K-gap; ++i) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = kp[i][j-1]; k <= kp[i+1][j]; ++k) {
                    if(dp[i][j] > dp[i][k] + dp[k + 1][j] + sumDist(sum, i, j)){
                        dp[i][j] = dp[i][k] + dp[k + 1][j] + sumDist(sum, i, j);
                        kp[i][j] = k;
                    }
                }
            }
        }
        sb.append(dp[0][K - 1]).append("\n");
    }

    public static int sumDist(int[] sum, int start, int end) {
        if (start == 0)
            return sum[end];
        return sum[end] - sum[start - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] chapters = new int[K];
            int[] sum = new int[K];
            for (int i = 0; i < K; ++i) {
                chapters[i] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    sum[i] = chapters[i];
                    continue;
                }
                sum[i] = sum[i - 1] + chapters[i];
            }
            solution(chapters, sum, K);
        }
        System.out.print(sb);
        br.close();
    }
}
