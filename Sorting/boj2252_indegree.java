package Sorting;

import java.io.*;
import java.util.*;

// BOJ 줄 세우기 <indegree>
public class boj2252_indegree {
    public static ArrayList<Integer>[] tree;
    public static Stack<Integer> stk;
    public static int[] indegree;

    public static void solution(int N){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; ++i){
            if(indegree[i] == 0) {
                indegree[i]--;
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int a = q.poll();
            sb.append(a).append(" ");

            for(Integer tmp : tree[a]){
                if(--indegree[tmp] == 0)
                    q.add(tmp);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        tree = new ArrayList[N+1];
        for(int i=0; i<=N; ++i)
            tree[i] = new ArrayList<>();

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            tree[b].add(a);
            indegree[a]++;
        }

        solution(N);
        br.close();
    }
}
