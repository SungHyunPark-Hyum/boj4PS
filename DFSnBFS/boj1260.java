package DFSnBFS;

import java.io.*;
import java.util.*;

// BOJ 1260 DFS와 BFS <DFS와 BFS>
public class boj1260 {
    public static int[][] map;
    public static boolean[] visit;
    public static int N, K;
    public static StringBuilder sb;

    public static void dfs(int now){
        for(int i=1; i<=N; ++i){
            if(!visit[i] && map[now][i] == 1) {
                visit[i] = true;
                sb.append(i).append(" ");
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()){
            int a = q.poll();
            sb.append(a).append(" ");
            for(int i=1; i<=N; ++i){
                if(map[a][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for(int i=0; i<K; ++i){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            map[f][t] = map[t][f] = 1;
        }

        sb = new StringBuilder();
        visit = new boolean[N+1];
        visit[V] = true;
        sb.append(V).append(" ");
        dfs(V);
        sb.append("\n");
        visit = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
        br.close();
    }
}
