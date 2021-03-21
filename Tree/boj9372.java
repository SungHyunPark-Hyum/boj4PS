package Tree;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// BOJ 9372 상근이의 여행
public class boj9372 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //    2
        //  1   3
        //     4  5
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(st.nextToken());
            for(int i=0; i<M; ++i){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
            }
            System.out.println(N-1);
        }
    }
}
