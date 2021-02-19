package BinarySearch;

import java.io.*;
import java.util.*;

// BOJ 10816 숫자 카드 2 <이분 탐색>
public class boj10816 {
    public static int lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;

        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid] >= target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    public static int upperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;

        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid] <= target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

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
            int target = Integer.parseInt(st.nextToken());
            int left = lowerBound(arr, target);
            int right = upperBound(arr, target);
            int ret = right - left;
            sb.append(ret).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
