package Tree;

import java.io.*;
import java.util.*;

// BOJ 1167 트리의 지름 <트리>
public class boj1167 {
    public static int V;
    public static boolean[] visit;
    public static int min = Integer.MAX_VALUE;
    public static ArrayList<ArrayList<Node>> tree = new ArrayList<ArrayList<Node>>();
    public static int maxNum = -1;
    public static int maxWeight = -1;

    public static void dfs(int parentIdx, int sum){
        if(maxWeight < sum){
            maxNum = parentIdx;
            maxWeight = sum;
        }

        for(Node child : tree.get(parentIdx)){
            if(!visit[child.num]){
                visit[child.num] = true;
                dfs(child.num, sum + child.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        for(int i=0; i<=V; ++i)
            tree.add(new ArrayList<Node>());

        StringTokenizer st;
        for(int l=0; l<V; ++l){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while(true){
                int child = Integer.parseInt(st.nextToken());
                if(child == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree.get(v).add(new Node(child, weight));
            }
        }
        visit = new boolean[V+1];
        visit[1] = true;
        dfs(1, 0);
        visit = new boolean[V+1];
        visit[maxNum] = true;
        dfs(maxNum, 0);
        System.out.println(maxWeight);
        br.close();
    }

    public static class Node{
        int num, weight;
        public Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
}
