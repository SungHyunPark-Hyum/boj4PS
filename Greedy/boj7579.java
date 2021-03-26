package Greedy;

import java.io.*;
import java.util.*;

// BOJ 7579 앱 <Dynamic Programming 2>
public class boj7579 {

    public static void solution(int[] mArr, int[] cArr, int M){
        int N = mArr.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[N+1][10000+1];
        for(int i=1; i<=N; ++i){
            for(int j=1; j<=10000; ++j){
                if(j >= cArr[i-1])
                    dp[i][j] = Math.max(dp[i-1][j-cArr[i-1]] + mArr[i-1], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
                if(dp[i][j] >= M){
                    ans = Math.min(j, ans);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] mArr = new int[N];
        int[] cArr = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int mSum = 0, cSum = 0;
        for(int i=0; i<N; ++i){
            mArr[i] = Integer.parseInt(st1.nextToken());
            mSum += mArr[i];
            cArr[i] = Integer.parseInt(st2.nextToken());
            cSum += cArr[i];
        }
        solution(mArr, cArr, M);
    }
}
