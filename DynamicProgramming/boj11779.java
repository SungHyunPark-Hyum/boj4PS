package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 최소비용 구하기 2
public class boj11779 {
    public static int n, m;
    public static int[] track;
    public static int[] dp;
    public static boolean[] visit;
    public static ArrayList<ArrayList<Data>> arr;

    public static void solution(int start, int end){
        // dijkstra
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node e1, Node e2){
                return e1.weight - e2.weight;
            }
        });

        pq.add(new Node(start, 0, -1));
        while(!pq.isEmpty()){
            Node e = pq.poll();
            if(dp[e.num] > e.weight) {
                track[e.num] = e.before;
                dp[e.num] = e.weight;
            }

            for(Data d : arr.get(e.num)){
                if(!visit[d.to])
                    pq.add(new Node(d.to, e.weight + d.weight, e.num));
            }
            visit[e.num] = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[end]).append("\n");
        Stack<Integer> stk = new Stack<>();
        int num = 0;
        while(end != -1){
            stk.push(end);
            end = track[end];
            num++;
        }
        sb.append(num).append("\n");
        while(!stk.isEmpty()){
            sb.append(stk.pop()).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        track = new int[n+1];
        dp = new int[n+1];
        visit = new boolean[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        arr = new ArrayList<ArrayList<Data>>();
        for(int i=0; i<=n; ++i)
            arr.add(new ArrayList<Data>());

        StringTokenizer st;
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Data(b, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        solution(start, end);
        br.close();
    }

    public static class Data{
        int to, weight;
        public Data(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Node{
        int num, weight, before;
        public Node(int num, int weight, int before){
            this.num = num;
            this.weight = weight;
            this.before = before;
        }
    }
}
