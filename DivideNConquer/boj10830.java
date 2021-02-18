package DivideNConquer;

import java.io.*;
import java.util.*;

// BOJ 10830 행렬 제곱 <분할 정복>
public class boj10830 {
    public static int[][] divide(int[][] A, long n){
        if(n == 1){
            int[][] tmp = new int[A.length][A.length];
            for(int i=0; i<A.length; i++)
                for(int j=0; j<A.length; ++j)
                    if(i==j)
                        tmp[i][j] = 1;
            return multiply_matrix(A, tmp);
        }
        else{
            int[][] ret = divide(A, n/2);
            if(n%2==0){
                return multiply_matrix(ret, ret);
            }
            else{
                return multiply_matrix(A, multiply_matrix(ret, ret));
            }
        }
    }

    public static int[][] multiply_matrix(int[][] A, int[][] B){
        int n = A.length;
        int[][] ret = new int[n][n];
        //  1 2 3   1 2 3
        // (2 3 4) (2 3 4)
        //  3 4 5   3 4 5
        // (0,1) = (0,0)*(0,1) + (0,1)*(1,1) + (0,2)*(2,1)
        for(int k=0; k<n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    ret[k][i] += A[k][j] * B[j][i];
                }
                ret[k][i] %= 1000;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] map = new int[N][N];
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] ans = divide(map, B);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
