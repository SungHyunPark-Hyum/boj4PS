package BinarySearch;

import java.io.*;
import java.util.*;

// BOJ 1654 랜선 자르기 <이분 탐색>
public class boj1654 {
    public static int[] lines;
    public static int N;

    public static long divide(int[] arr, int len){
        long ans = 0;
        int tmp = 0;
        long l = 1;
        long r = len;
        long mid = -1;
        while(l <= r){
            tmp = 0;
            mid = (l+r)/2;
            for(int i=0; i<arr.length; ++i){
                tmp += arr[i] / mid;
            }
            if(tmp >= N){
                ans = Math.max(ans, mid);
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new int[K];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<K; ++i){
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(lines[i], max);
        }
        System.out.println(divide(lines, max));
    }
}
