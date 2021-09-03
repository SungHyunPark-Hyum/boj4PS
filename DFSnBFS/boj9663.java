package DFSnBFS;

import java.io.*;
import java.util.*;

// BOJ 9663 N-Queen
public class boj9663 {
    public static int n;
    public static boolean[] visitedY;
    public static boolean[][] map;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visitedY = new boolean[n];
        map = new boolean[n][n];

        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int x){
        if(x == n){
            count++;
            return;
        }

        for(int i=0; i<n; ++i){
            if(check(x, i)){
                map[x][i] = true;
                visitedY[i] = true;
                dfs(x+1);
                map[x][i] = false;
                visitedY[i] = false;
            }
        }
    }

    public static boolean check(int x, int y){
        if(x < 0 || y < 0 || x>=n || y>=n) return false;
        if(visitedY[y]) return false;

        int j = y-1;
        for(int i=x+1; i<n; ++i){
            if(j==-1) break;
            if(map[i][j]) return false;
            j--;
        }

        j = y-1;
        for(int i=x-1; i>=0; --i){
            if(j==-1) break;
            if(map[i][j]) return false;
            j--;
        }

        j = y+1;
        for(int i=x-1; i>=0; --i){
            if(j==n) break;
            if(map[i][j]) return false;
            j++;
        }

        j = y+1;
        for(int i=x+1; i<n; ++i){
            if(j==n) break;
            if(map[i][j]) return false;
            j++;
        }

        return true;
    }
}

// 1 x x x x x
// x x 0 0 0 0
// x 0 x 0 0 0
// x 0 0 x 0 0
// x 0 0 0 x 0
// x 0 0 0 0 x
