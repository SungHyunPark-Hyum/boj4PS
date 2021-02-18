package DivideNConquer;

import java.io.*;
import java.util.*;

// BOJ 1629 곱셈 <분할 정복>
public class boj1629 {
    public static int A, B, C;

    public static long recurs(int a, int b, int c){
        if(b == 1) {
            return a % c;
        }

        long tmp = recurs(a, b/2, c);
        if(b%2 == 0){
            return tmp * tmp % c;
        }
        else{
            return (tmp * tmp % c) * a % c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(recurs(A, B, C));
    }
}
