package Stack_Queue_Deque;

import java.io.*;

// BOJ 10844 쉬운 계단 수 <동적 계획법>
// not yet, will try later
public class boj10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 나중에 풀고 내가 처음 직접 계산해서 만든 점화식이 안되는 거 확인하기
        // 1 : 9
        // 2 : 17 = dp[1] * 2 - 1;
        // 3 : 32 = dp[2] * 2 - 2;
        // 4 : 61 = dp[3] * 2 - 3;
//        int[] dp = new int[N+1];
//        dp[1] = 9;
//        for(int i=2; i<=N; ++i){
//            dp[i] = (dp[i-1] * 2 - (i-1)) % 1000000000;
//        }
//        System.out.println(dp[N]);
    }
}
