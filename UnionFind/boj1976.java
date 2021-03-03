import java.io.*;
import java.util.*;

// BOJ 1976 여행 가자 <유니온 파인드>
public class boj1976 {
    public static int N, M;
    public static boolean[] visit;
    public static int[] parent;
    public static ArrayList<ArrayList<Integer>> arr;

    public static void dfs(int a){

        for(int child : arr.get(a)){
            if(!visit[child]) {
                visit[child] = true;
                union(a, child);
                dfs(child);
            }
        }
    }

    public static void solution(int[] arr){
        int tp = find(parent[arr[0]]);
        for(int i=1; i<arr.length; ++i){
            if(find(arr[i]) != tp){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb)
            return;

        parent[pa] = pb;
    }

    public static int find(int a){
        if(a==parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList<ArrayList<Integer>>();
        visit = new boolean[N+1];
        parent = new int[N+1];
        for(int i=0; i<=N; ++i) {
            arr.add(new ArrayList<Integer>());
            parent[i] = i;
        }

        StringTokenizer st;
        for(int i=1; i<=N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; ++j){
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    arr.get(i).add(j);
                    arr.get(j).add(i);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] target = new int[M];
        for(int i=0; i<M; ++i){
            target[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; ++i){
            if(!visit[i]){
                visit[i] = true;
                dfs(i);
            }
        }
        solution(target);
    }
}
