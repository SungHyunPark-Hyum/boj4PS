import java.util.*;
import java.io.*;

//BOJ_1018 체스판 다시 칠하기 <브루트포스>
public class boj1018 {
    public static char[][] mat;
    public static int min;

    public static int func_w(int x, int y) {
        int ret = 0;
        int flagX = x%2;
        int flagY = y%2;
        for(int i=x; i<x+8; ++i){
            if(i%2 == flagX) {
                for (int j = y; j < y + 8; ++j) {
                    if (j % 2 == flagY) {
                        if (mat[i][j] != 'W')
                            ret++;
                    } else {
                        if (mat[i][j] == 'W')
                            ret++;
                    }
                }
            }
            else{
                for (int j = y; j < y + 8; ++j) {
                    if (j % 2 == flagY) {
                        if (mat[i][j] != 'B')
                            ret++;
                    } else {
                        if (mat[i][j] == 'B')
                            ret++;
                    }
                }
            }
        }
        return ret;
    }

    public static int func_b(int x, int y) {
        int ret = 0;
        int flagX = x%2;
        int flagY = y%2;
        for(int i=x; i<x+8; ++i){
            if(i%2 == flagX) {
                for (int j = y; j < y + 8; ++j) {
                    if (j % 2 == flagY) {
                        if (mat[i][j] != 'B')
                            ret++;
                    } else {
                        if (mat[i][j] == 'B')
                            ret++;
                    }
                }
            }
            else{
                for (int j = y; j < y + 8; ++j) {
                    if (j % 2 == flagY) {
                        if (mat[i][j] != 'W')
                            ret++;
                    } else {
                        if (mat[i][j] == 'W')
                            ret++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        mat = new char[x][y];
        min = x*y;
        for(int i=0; i<x; ++i){
            String line = br.readLine();
            for(int j=0; j<line.length(); ++j){
                mat[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<x-7; ++i){
            for(int j=0; j<y-7; ++j){
                int min_w = func_w(i, j);
                int min_b = func_b(i, j);
                min = Math.min(min, Math.min(min_w, min_b));
            }
        }
        System.out.println(min);
    }
}
