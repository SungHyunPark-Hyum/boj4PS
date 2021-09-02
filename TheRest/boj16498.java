package TheRest;

import java.io.*;
import java.util.*;

// BOJ 16498 작은 벌점
public class boj16498 {
    public static int[] abc;
    public static int[][] p;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        abc = new int[3];
        p = new int[3][];
        for(int i=0; i<3; ++i){
            abc[i] = Integer.parseInt(st.nextToken());
            p[i] = new int[abc[i]];
        }

        for(int i=0; i<3; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<abc[i]; ++j){
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<p[0].length; ++i){
            dfs(1, p[0][i], p[0][i]);
        }

        System.out.println(min);
    }

    public static void dfs(int a, int mx, int mn){
        if(a == 2){
            if(Math.abs(mx-mn) > min)
                return;
        }

        if(a == 3){
            int result = Math.abs(mx-mn);
            min = Math.min(result, min);
            return;
        }

        for(int i=0; i<p[a].length; ++i){
            int min = Math.min(mn, p[a][i]);
            int max = Math.max(mx, p[a][i]);
            dfs(a+1, max, min);
        }
    }
}
