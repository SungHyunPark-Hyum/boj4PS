package TheRest;

import java.io.*;
import java.util.*;

// BOJ 2798 블랙잭
public class boj2798 {
    public static int N, M;
    public static int[] arr;
    public static int min;

    public static void comb(boolean[] visit, int index, int count, int target){
        if(count == target){
            int tmp = add(visit);
            if(tmp > M)
                return;
            min = Math.min(min, M - tmp);
            return;
        }
        if(index == visit.length){
            return;
        }

        visit[index] = true;
        comb(visit, index+1, count+1, target);

        visit[index] = false;
        comb(visit, index+1, count, target);
    }

    public static int add(boolean[] visit){
        int ret = 0;
        for(int i=0; i<visit.length; ++i){
            if(visit[i])
                ret += arr[i];
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        min = M;

        boolean[] visit = new boolean[N];
        comb(visit, 0, 0, 3);
        System.out.println(M - min);
    }
}
