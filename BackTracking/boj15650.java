package BackTracking;

import java.util.*;
import java.io.*;

// BOJ 15650 N과 M(2) <백트래킹 단계>
public class boj15650 {
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static int[] arr;

    public static void nNm(int a, int depth){
        if(M==depth){
            for(int var : arr){
                sb.append(var).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=a; i<=N; ++i){
            arr[depth] = i;
            nNm(i+1, depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        nNm(1, 0);
        System.out.println(sb.toString());
    }
}
