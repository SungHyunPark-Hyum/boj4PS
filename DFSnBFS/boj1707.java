package DFSnBFS;

import java.io.*;
import java.util.*;

// BOJ 1702 이분 그래프 <DFS와 BFS>
public class boj1707 {
    public static int V, E;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visit, color;

    public static String solution(ArrayList<ArrayList<Integer>> arr, int start){
        if(visit[start] || arr.get(start).size() == 0)
            return "YES";

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, true));
        visit[start] = true;

        while(!q.isEmpty()){
            Node a = q.poll();
            color[a.num] = a.color;

            for(int i=0; i<arr.get(a.num).size(); ++i){
                int vertex = arr.get(a.num).get(i);
                if(!visit[vertex]){
                    q.add(new Node(vertex, !a.color));
                    visit[vertex] = true;
                }
            }
        }

        Queue<Integer> qq = new LinkedList<>();
        qq = new LinkedList<>();
        qq.add(start);
        boolean[] visit2 = new boolean[V];

        while(!qq.isEmpty()){
            int a = qq.poll();

            for(int i=0; i<arr.get(a).size(); ++i){
                int vertex = arr.get(a).get(i);
                if(color[vertex] == color[a]){
                    return "NO";
                }
                if(!visit2[vertex]){
                    qq.add(vertex);
                    visit2[vertex] = true;
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int l=0; l<K; ++l) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int i=0; i<V; ++i){
                arr.add(new ArrayList<>());
            }
            for(int i=0; i<E; ++i){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                arr.get(v1-1).add(v2-1);
                arr.get(v2-1).add(v1-1);
            }

            visit = new boolean[V];
            color = new boolean[V];
            String ans = null;
            for(int i=0; i<V; ++i) {
                ans = solution(arr, i);
                if(ans.equals("NO"))
                    break;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static class Node{
        public int num;
        public boolean color;
        public Node(int num, boolean color){
            this.num = num;
            this.color = color;
        }
    }
}
