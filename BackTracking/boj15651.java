package BackTracking;

import java.util.*;
import java.io.*;

// BOJ 15651 N과 M(3) <백트래킹 단계>
public class boj15651 {

    public static StringBuilder sb = new StringBuilder();
    public static int n, m;
    public static int[] arr;

    public static void dfs(int a, int depth){
        if(depth == m){
            for(int var : arr)
                sb.append(var).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; ++i){
            arr[a] = i+1;
            dfs(a+1, depth+1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(0, 0);
        System.out.println(sb);
    }
}
