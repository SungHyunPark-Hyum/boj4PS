package Tree;

import java.io.*;
import java.util.*;

// BOJ 4803 트리 <트리>
public class boj4803 {
    public static int order = 1;
    public static int n, m;
    public static ArrayList<ArrayList<Integer>> tree;
    public static String[] ans = {
            "Case ",
            ": A forest of ",
            " trees.",
            ": There is one tree.",
            ": No trees."};
    public static int[] parent;
    public static boolean[][] visit;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static boolean flag;

    public static void dfs(int root){

        for(Integer child : tree.get(root)){
            if(visit[root][child]){
                visited[child] = true;
                visit[root][child] = false;
                visit[child][root] = false;
                union(root, child);
                dfs(child);
            }
        }
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb){
            flag = false;
            return;
        }

        parent[pb] = pa;
    }

    public static int find(int a){
        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m==0)
                break;
            tree = new ArrayList<ArrayList<Integer>>();
            parent = new int[n+1];
            visit = new boolean[n+1][n+1];
            for(int l=0; l<=n; ++l) {
                tree.add(new ArrayList<Integer>());
                parent[l] = l;
            }

            for(int l=0; l<m; ++l){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree.get(a).add(b);
                tree.get(b).add(a);
                visit[a][b] = visit[b][a] = true;
            }

            visited = new boolean[n+1];
            int T = 0;
            for(int i=1; i<=n; ++i){
                if(!visited[i]){
                    flag = true;
                    visited[i] = true;
                    dfs(i);
                    if(flag){
                        T++;
                    }
                    else{
                        flag = true;
                    }
                }
            }
            addAns(T);
        }
        System.out.print(sb);
        br.close();
    }

    public static void addAns(int T){
        sb.append(ans[0]).append(order++);
        if(T == 0){
            sb.append(ans[4]).append("\n");
        }
        else if(T > 1){
            sb.append(ans[1]).append(T).append(ans[2]).append("\n");
        }
        else{
            sb.append(ans[3]).append("\n");
        }
    }
}
