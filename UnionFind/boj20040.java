package UnionFind;

import java.io.*;
import java.util.*;

// BOJ 20040 사이클 게임 <유니온 파인드>
public class boj20040 {
    public static int n, m;
    public static int[] parent;

    public static boolean solution(int a, int b){
        return union(a, b);
    }

    public static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) {
            return true;
        }

        parent[pb] = pa;
        return false;
    }

    public static int find(int a){
        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i=0; i<n; ++i) parent[i] = i;
        boolean flag = false;
        boolean flag2 = false;
        int ans = 0;

        for(int l=1; l<=m; ++l){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!flag) {
                flag = solution(a, b);
            }
            if(flag){
                if(!flag2) {
                    ans = l;
                    flag2 = true;
                }
            }
        }
        System.out.println(ans);
    }
}
