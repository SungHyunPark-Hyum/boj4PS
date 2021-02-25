package BinarySearch;

import java.io.*;
import java.util.*;

// BOj 12865 평범한 배낭 <동적 계획법>
public class boj12865 {
    public static int N, K;
    public static int a;
    public static int[][] dp;

    public static void solution(ArrayList<Knapsack> knapsacks){
        for(int i=1; i<=knapsacks.size(); ++i){
            Knapsack tmp = knapsacks.get(i-1);
            for(int j=1; j<=K; ++j){
                if(j - tmp.weight >= 0)
                    dp[i][j] = Math.max(dp[i-1][j-tmp.weight] + tmp.value, dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][K]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Knapsack> knapsacks = new ArrayList<Knapsack>();
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            knapsacks.add(new Knapsack(w, v));
        }
        dp = new int[N+1][K+1];

        Comparator<Knapsack> cmp = new Comparator<Knapsack>() {
            @Override
            public int compare(Knapsack o1, Knapsack o2) {
                return o1.weight - o2.weight;
            }
        };

        Collections.sort(knapsacks, cmp);
        solution(knapsacks);
    }

    public static class Knapsack{
        public int weight, value;
        public Knapsack(int w, int v){
            this.weight = w;
            this.value = v;
        }
    }
}
