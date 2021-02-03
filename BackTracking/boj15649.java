package BackTracking;

import java.util.*;
import java.io.*;

// BOJ 15649 N과 M(1) <백트래킹 단계>
public class boj15649 {
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void nNm(int n, int m, ArrayList<Integer> arr){
        if(m==0){
            for(int i=0; i<arr.size(); ++i){
                sb.append(arr.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; ++i){
            if(!visited[i]){
                visited[i] = true;
                arr.add(i+1);
                int idx = arr.size()-1;
                nNm(n, m-1, arr);
                visited[i] = false;
                arr.remove(idx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        ArrayList<Integer> arr = new ArrayList<>();

        nNm(n, m, arr);
        System.out.println(sb.toString());
    }
}
