package UnionFind;

import java.io.*;
import java.util.*;

// BOJ 1717 집합의 표현 <유니온 파인드>
public class boj1717 {
    public static int n, m;
    public static int[] parent;

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb)
            return;

        parent[pa] = pb;
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
        parent = new int[n+1];
        for(int i=0; i<=n; ++i)
            parent[i] = i;

        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 확인
            if(flag == 1){
                if(find(a) == find(b))
                    sb.append("YES");
                else
                    sb.append("NO");
                sb.append("\n");
            }
            // 합집합
            else{
                union(a, b);
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
