package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 11053 가장 긴 증가하는 부분 수열 <동적 계획법 1>
public class boj11053 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ret = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i){
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }
        int size = 0;
        ret[0] = arr[0];
        int idx = 0;
        for(int i=1; i<N; ++i){
            if(ret[idx] < arr[i]){
                idx++;
                ret[idx] = arr[i];
            }
            else if(ret[idx] > arr[i]){
                //이진 탐색 함수는 target을 못찾을 경우 음수로 마지막 찾은 위치를 반환
                int index = Arrays.binarySearch(ret, 0, idx, arr[i]);
                if(index < 0){
                    index = -index - 1;
                }
                ret[index] = arr[i];
            }
        }
        System.out.println(idx+1);
    }
}
