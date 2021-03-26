package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 7579 앱 <Dynamic Programming 2>
public class boj7579 {

    public static void solution(int[] mArr, int[] cArr, int M, int mSum, int cSum){
        int N = mArr.length;
        int nM = mSum - M;
        int[][] dp = new int[N+1][nM+1];
        for(int i=1; i<=N; ++i){
            for(int j=1; j<=nM; ++j){
                if(j-mArr[i-1] >= 0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-mArr[i-1]] + cArr[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(cSum - dp[N][nM]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[] mArr = new int[N];
        int[] cArr = new int[N];
        st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int mSum = 0, cSum = 0;
        for(int i=0; i<N; ++i){
            mArr[i] = Integer.parseInt(st1.nextToken());
            mSum += mArr[i];
            cArr[i] = Integer.parseInt(st2.nextToken());
            cSum += cArr[i];
        }
        solution(mArr, cArr, M, mSum, cSum);
    }
}
