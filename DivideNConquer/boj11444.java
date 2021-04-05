package DivideNConquer;

import java.io.*;
import java.util.*;

// BOJ 11444 피보나치 수6
public class boj11444 {

    public static long[][] a1 = {{1,1},{1,0}};

    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] ret = new long[2][2];
        //ret[i][j] = a[i][k] * b[k][j]
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 2; ++k) {
                    ret[i][j] += a[i][k] * b[k][j];
                    ret[i][j] %= 1000000007;
                }
            }
        }
        return ret;
    }

    public static long[][] fibonacci(long n) {
        if(n==1)
            return a1;
        if(n==2)
            return multiply(a1, a1);

        long[][] tmp = fibonacci(n/2);
        if(n%2== 0) {
            return multiply(tmp, tmp);
        }
        else{
            return multiply(a1, multiply(tmp, tmp));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] answer = fibonacci(n);
        System.out.println(answer[0][1]);
    }
}
