package DivideNConquer;

import java.io.*;
import java.util.*;

public class boj1780 {
    public static int[] answer;
    public static int[][] map;

    public static void divide(int x, int y, int k){
        int tmp = conquer(x, y, k);
        if(tmp != -1){
            answer[tmp]++;
            return;
        }

        int kk = k/3;
        divide(x, y, kk);
        divide(x+kk, y, kk);
        divide(x + kk*2, y, kk);
        divide(x, y+kk, kk);
        divide(x, y+kk*2, kk);
        divide(x+kk, y+kk, kk);
        divide(x+kk, y+kk*2, kk);
        divide(x+kk*2, y+kk, kk);
        divide(x+kk*2, y+kk*2, kk);
    }

    public static int conquer(int x, int y, int k){
        int flag = map[x][y];
        for(int i=x; i<x+k; ++i){
            for(int j=y; j<y+k; ++j){
                if(map[i][j] != flag)
                    return -1;
            }
        }
        return flag+1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int [N][N];
        answer = new int[3];

        StringTokenizer st;
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0, N);
        for(int i=0; i<3; ++i){
            System.out.println(answer[i]);
        }
    }
}
