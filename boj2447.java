import java.util.*;
import java.io.*;

// BOJ_2447 별찍기 - 10 <재귀 단계>
public class boj2447 {
    public static char[][] mat;

    public static void draw(int x, int y){
        for(int i=0; i<3; ++i) {
            for (int j = 0; j < 3; ++j) {
                mat[x + i][y + j] = '*';
                if(i==1 && j==1)
                    mat[x+i][y+j] = ' ';
            }
        }
    }

    public static void draw_blank(int x, int y, int len){
        for(int i=0; i<len; ++i){
            for(int j=0; j<len; ++j){
                mat[x+i][y+j] = ' ';
            }
        }
    }

    public static void func(int x, int y, int length){
        int len = length/3;
        if(len == 1){
            draw(x, y);
            return;
        }

        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j){
                if(i==1 & j ==1)
                    draw_blank(x+len*i, y +len*j, len);
                else
                    func(x + len*i, y + len*j, len);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        mat = new char[N][N];
        func(0, 0, N);
        for(int i=0; i<N; ++i){
            sb.append(String.copyValueOf(mat[i])).append("\n");
        }
        System.out.println(sb);
    }
}
