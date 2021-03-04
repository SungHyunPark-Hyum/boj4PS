package Tree;

import java.io.*;
import java.util.*;

// BOJ 15681 트리와 쿼리 <트리>
public class boj15681 {
    public static int N, R, Q;
    public static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
    public static int[] dp;
    public static boolean[] visit;

    public static int buildTree(int root){
        if(dp[root] != 0){
            return dp[root];
        }
        dp[root] = 1;

        for(Integer child : tree.get(root)){
            if(!visit[child]) {
                visit[child] = true;
                dp[root] += buildTree(child);
            }
        }

        return dp[root];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        dp = new int[N+1];
        visit = new boolean[N+1];
        for(int i=0; i<=N; ++i)
            tree.add(new ArrayList<Integer>());

        for(int i=1; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        visit[R] = true;
        buildTree(R);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; ++i){
            int a = Integer.parseInt(br.readLine());
            sb.append(dp[a]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
