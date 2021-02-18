package DivideNConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2630 색종이 만들기 <분할 정복>
public class boj2630 {
    public static int map[][];
    public static int white = 0;
    public static int blue = 0;

    public static void divide(int x, int y, int len){
        int res = conquer(x, y, len);
        if(res == 0){
            white++;
            return;
        }
        else if(res == 1){
            blue++;
            return;
        }
        else{
            int div = len/2;
            divide(x, y, div);
            divide(x + div, y, div);
            divide(x, y + div, div);
            divide(x + div, y + div, div);
        }
    }

    public static int conquer(int x, int y, int len){
        int ret = map[x][y];
        for(int i=x; i<x+len; ++i){
            for(int j=y; j<y+len; ++j){
                if(map[i][j] != ret) {
                    return -1;
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0 -> white
        // 1 -> blues
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
}
