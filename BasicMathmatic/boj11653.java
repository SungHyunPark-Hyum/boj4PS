package BasicMathmatic;

import java.io.*;
import java.util.*;

// BOJ 11653 소인수분해 <기본 수학 2단계>
public class boj11653 {

    public static void func(int n) {
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                    System.out.println(i);
                }
            }
            if (n == 1)
                return;
        }
        if(n != 1)
            System.out.println(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        func(N);
    }
}
