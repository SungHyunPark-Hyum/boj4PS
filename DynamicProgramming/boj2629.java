package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 2629 양팔저울.
public class boj2629 {
    public static boolean[] visit = new boolean[40501];
    public static StringBuilder sb = new StringBuilder();

    public static void check(int[] weights){
        int len = weights.length;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=len-1; i>=0; --i){
            int t = arr.size();
            for(int j=0; j<t; ++j){
                int minus = arr.get(j) - weights[i];
                int plus = arr.get(j) + weights[i];
                if(arr.get(j) < 0){
                    minus = arr.get(j) + weights[i];
                    if(minus < 0)
                        minus *= -1;
                    plus = -1 * arr.get(j) + weights[i];
                }
                if(minus > 0 && !visit[minus]){
                    arr.add(-1 * minus);
                    visit[minus] = true;
                }
                if(plus <= 40500 && !visit[plus]){
                    arr.add(plus);
                    visit[plus] = true;
                }
            }
            if(!visit[weights[i]]) {
                visit[weights[i]] = true;
                arr.add(weights[i]);
            }
        }
    }

    public static void checkAns(int a) {
        if(visit[a]) sb.append("Y ");
        else sb.append("N ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] weights = new int[T];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; ++i){
            weights[i] = Integer.parseInt(st.nextToken());
        }
        check(weights);

        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(t-- > 0){
            int target = Integer.parseInt(st.nextToken());
            checkAns(target);
        }

        System.out.println(sb);
        br.close();
    }
}
