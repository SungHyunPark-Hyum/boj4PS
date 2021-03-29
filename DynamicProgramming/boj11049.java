package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 11049 행렬 곱셈 순서
public class boj11049 {
    public static StringBuilder sb = new StringBuilder();

    public static void solution(Matrix[] matrices, int N){
        int[][] dp = new int[N][N];

        for(int i=0; i<N-1; ++i){
            dp[i][i+1] = calcMatrix(matrices, i, i+1, i+1);
        }

        for(int gap = 2; gap < N; ++gap){
            for(int i=0; i<N-gap; ++i){
                int j = i + gap;

                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; ++k){
                    dp[i][j] = Math.min(dp[i][k] + dp[k+1][j] + calcMatrix(matrices, i, k+1, j), dp[i][j]);
                }
            }
        }

        sb.append(dp[0][N-1]);
    }

    public static int calcMatrix(Matrix[] matrices, int i, int j, int k){
        return matrices[i].m * matrices[j].m * matrices[k].n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Matrix[] matrices = new Matrix[N];
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrices[i] = new Matrix(a, b);
        }

        solution(matrices, N);

        System.out.println(sb);
        br.close();
    }

    public static class Matrix{
        public int m, n;
        public Matrix(int m, int n){
            this.m = m;
            this.n = n;
        }
    }
}
