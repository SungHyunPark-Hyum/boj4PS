package TwoPointer;

import java.io.*;
import java.util.*;

// BOJ 2470 두 용액
public class boj2470 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = arr.length-1;
        int min = Integer.MAX_VALUE;
        int ansL = -1, ansR = -1;
        while(l<r){
            int tmp = arr[l] + arr[r];
            if(min > Math.abs(tmp)){
                ansL = l;
                ansR = r;
                min = Math.abs(tmp);
            }
            if(tmp == 0){
                ansL = l;
                ansR = r;
                break;
            }
            else if(tmp < 0) l++;
            else r--;
        }
        System.out.println(arr[ansL] + " " + arr[ansR]);
        br.close();
    }
}
