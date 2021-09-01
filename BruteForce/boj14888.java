package BruteForce;

import java.io.*;
import java.util.*;

// BOJ 14888 연산자 끼워넣기
public class boj14888 {
    public static int[] num, ops;
    public static int n, min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        ops = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            ops[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(0, num[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int idx, int before) {
        if (idx == n - 1) {
            max = Math.max(before, max);
            min = Math.min(before, min);
            return;
        }

        for (int i = 0; i < 4; ++i) {
            if(ops[i] > 0){
                ops[i]--;
                dfs(idx + 1, calc(before, num[idx + 1], i));
                ops[i]++;
            }
        }
    }

    public static int calc(int a, int b, int oi) {
        switch (oi) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3: {
                if (a < 0 && b > 0) {
                    a *= -1;
                    int ret = a/b;
                    return ret * -1;
                }
                return a / b;
            }
        }
        return Integer.MAX_VALUE;
    }
}
