package DivideNConquer;

import java.io.*;
import java.util.*;

// BOJ 1992 쿼드트리 <분할 정복>
public class boj1992 {
    public static int N;
    public static int[][] map;
    public static StringBuilder sb = new StringBuilder();

    public static void divide(int x, int y, int n){
        int res = conquer(x, y, n);
        if(res != -1){
            sb.append(res);
            return;
        }

        sb.append("(");
        divide(x, y, n/2);
        divide(x, y+n/2, n/2);
        divide(x+n/2, y, n/2);
        divide(x+n/2, y+n/2, n/2);
        sb.append(")");
    }

    public static int conquer(int x, int y, int n){
        int ret = map[x][y];
        for(int i=x; i<x+n; ++i){
            for(int j=y; j<y+n; ++j){
                if(map[i][j] != ret)
                    return -1;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        String str;
        for(int i=0; i<N; ++i){
            str = br.readLine();
            for(int j=0; j<N; ++j){
                map[i][j] = str.charAt(j) -'0';
            }
        }
        divide(0, 0, N);
        System.out.println(sb);
    }
}
