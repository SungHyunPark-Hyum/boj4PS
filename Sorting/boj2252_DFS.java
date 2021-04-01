package Sorting;

import java.io.*;
import java.util.*;

// BOJ 줄 세우기 <DFS>
public class boj2252_DFS {
    public static ArrayList<Integer>[] tree;
    public static Stack<Integer> stk;
    public static boolean[] visit;

    public static void dfs(int a){
        visit[a] = true;
        for(Integer child : tree[a]){
            if(!visit[child]){
                dfs(child);
            }
        }
        stk.push(a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        tree = new ArrayList[N+1];
        for(int i=0; i<=N; ++i)
            tree[i] = new ArrayList<>();

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            tree[b].add(a);
        }

        stk = new Stack<Integer>();
        for(int i=1; i<=N; ++i){
            if(!visit[i])
                dfs(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop()).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
