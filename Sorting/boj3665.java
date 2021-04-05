package Sorting;

import java.io.*;
import java.util.*;

// BOJ 3665 최종 순위
public class boj3665 {
    public static String imp = "IMPOSSIBLE";
    public static String unknown = "?";
    public static int[] rank;
    public static int[] rRank;
    public static StringBuilder sb = new StringBuilder();
    public static PriorityQueue<Node> pq;

    public static void solution(int n) {
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node e = pq.poll();
            if (e.order != i++) {
                sb.append(imp).append("\n");
                return;
            }

            ans.add(e.num);
        }
        for (Integer a : ans)
            sb.append(a).append(" ");
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            rank = new int[n + 1];
            rRank = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                int idx = Integer.parseInt(st.nextToken());
                rank[idx] = i;
                rRank[idx] = i;
            }

            pq = new PriorityQueue<Node>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.order - o2.order;
                }
            });
            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(rRank[b] < rRank[a]) {
                    rank[b]++;
                    rank[a]--;
                }
                else{
                    rank[b]--;
                    rank[a]++;
                }
            }
            for (int i = 1; i <= n; ++i) {
                pq.add(new Node(i, rank[i]));
            }
            solution(n);
        }
        System.out.print(sb);
        br.close();
    }

    public static class Node {
        int num, order;

        public Node(int num, int order) {
            this.num = num;
            this.order = order;
        }
    }
}
