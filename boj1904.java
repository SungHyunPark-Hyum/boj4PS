import java.io.*;
import java.util.*;

// BOJ 1904 01타일 <동적 계획법 1>.
public class boj1904 {
    public static int[] dp;
    public static void func(int n){
        dp[1] = 1;
        if(n >= 2) dp[2] = 2;
        if(n == 1 || n == 2){
            System.out.println(dp[n]);
            return;
        }
        for(int i=3; i<=n; ++i){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        func(N);
    }
}
