package BinarySearch;

import java.io.*;
import java.util.*;

// BOJ 12015 가장 긴 증가하는 부분 수열 2 <이분 탐색>
public class boj12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        ans[0] = arr[0];
        int idx = 0;

        for(int i=1; i<N; ++i){
            if(ans[idx] < arr[i]){
                idx++;
                ans[idx] = arr[i];
            }
            else if(ans[idx] > arr[i]){
                // idx : 0 1 2 3
                // val : 2 4 6 8
                // if key is 3 -> return -2
                int index = Arrays.binarySearch(ans, 0, idx, arr[i]);
                if(index < 0){
                    index = -index -1;
                }
                ans[index] = arr[i];
            }
        }

        System.out.println(idx+1);
    }
}
