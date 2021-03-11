package BackTracking;

import java.io.*;
import java.util.*;

// BOJ 13913 숨바꼭질 4
public class boj13913 {
    public static int N, K;
    public static int[] dp;
    public static int[] before;
    public static StringBuilder sb = new StringBuilder();

    public static void bfs(int n, int k){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        dp[n] = 0;
        before[n] = -1;

        while(!q.isEmpty()){
            int e = q.poll();
            if(e == k)
                break;

            for(int i=-1; i<=3; i+=2){
                int next;
                if(i!=3) next = e + i;
                else next = e*2;

                if(isPossible(next)){
                    dp[next] = dp[e] + 1;
                    before[next] = e;
                    q.add(next);
                }
            }
        }
    }

    public static boolean isPossible(int a){
        if(a < 0 || a > 2*K+4) return false;
        if(dp[a] != -1) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N < K) {
            before = new int[2 * K + 5];
            dp = new int[2 * K + 5];
            Arrays.fill(dp, -1);

            bfs(N, K);
            sb.append(dp[K]).append("\n");

            ArrayList<Integer> tmp = new ArrayList<>();
            while (K != -1) {
                tmp.add(K);
                K = before[K];
            }
            for (int i = tmp.size() - 1; i >= 0; --i)
                sb.append(tmp.get(i)).append(" ");

            System.out.println(sb);
        }
        else{
            sb.append(N-K).append("\n");
            for(int i = N; i >= K; --i){
                sb.append(i).append(" ");
            }

            System.out.println(sb);
        }
        br.close();
    }

    public static class Node{
        int num, before;
        public Node(int num, int before){
            this.num = num;
            this.before = before;
        }
    }
}
