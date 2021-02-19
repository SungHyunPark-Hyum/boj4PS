package BinarySearch;

import java.io.*;
import java.util.*;

// BOJ 1920 수 찾기 <이분 탐색>
public class boj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; ++i){
            int a = Integer.parseInt(st.nextToken());
            int idx = Arrays.binarySearch(arr, a);
            if(idx < 0){
                sb.append(0).append("\n");
            }
            else{
                sb.append(1).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
