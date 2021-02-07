package Greedy;

import java.io.*;
import java.util.*;

// BOJ 11047 동전 0 <그리디 알고리즘>
public class boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for(int i=0; i<N; ++i){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for(int i=N-1; i>=0; --i){
            int coin = coins[i];
            if(K-coin >= 0){
                int add = K/coin;
                K -= add*coin;
                ans += add;
                if(K == 0){
                    System.out.println(ans);
                    return;
                }
            }
        }
    }
}
