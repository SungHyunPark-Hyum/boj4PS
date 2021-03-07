package UnionFind;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

// BOJ 4195 친구 네트워크 <유니온 파인드>
public class boj4195 {
    public static HashMap<String, Integer> hm;
    public static int[] parent;
    public static int[] network;
    public static int idx;
    public static StringBuilder sb = new StringBuilder();

    public static void solution(String f1, String f2){
        if(!check(f1)) allocate(f1);
        if(!check(f2)) allocate(f2);

        int idx1 = hm.get(f1);
        int idx2 = hm.get(f2);

        union(idx1, idx2);
        sb.append(network[parent[idx1]]).append("\n");
    }

    public static boolean check(String f){
        if(hm.containsKey(f)) return true;
        else return false;
    }

    public static void allocate(String f){
        hm.put(f, idx++);
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) {
            network[pb] += network[pa];
            network[pa] = network[pb];
            parent[pa] = pb;
        }
    }

    public static int find(int a){
        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int F = Integer.parseInt(br.readLine());
            idx = 0;
            parent = new int[2*F];
            for(int j=0; j<2*F; ++j)
                parent[j] = j;
            network = new int[2*F];
            Arrays.fill(network, 1);
            hm = new HashMap<String, Integer>();
            for(int i=0; i<F; ++i){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                solution(f1, f2);
            }
        }
        System.out.print(sb);
        br.close();
    }
}
