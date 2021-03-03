import java.io.*;
import java.util.*;

// BOJ 11725 트리의 부모 찾기 <트리>
public class boj11725 {
    public static int N;
    public static int[] parent;
    public static ArrayList<ArrayList<Integer>> arr;
    public static StringBuilder sb = new StringBuilder();

    public static void solution(){
        Queue<Integer> q = new LinkedList<>();
        parent[1] = 1;
        q.add(1);

        while(!q.isEmpty()){
            int p = q.poll();

            for(int c : arr.get(p)){
                if(parent[c] == 0) {
                    parent[c] = p;
                    q.add(c);
                }
            }
        }

        for(int i=2; i<=N; ++i){
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        arr = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=N; ++i){
            arr.add(new ArrayList<Integer>());
        }

        StringTokenizer st;
        for(int i=1; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        solution();
        br.close();
    }
}
