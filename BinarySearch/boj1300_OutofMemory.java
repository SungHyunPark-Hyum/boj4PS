package BinarySearch;

import java.io.*;
import java.util.*;

// BOJ 1300 K번째 수 <이분 탐색>
public class boj1300_OutofMemory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Long> arr = new ArrayList<Long>();
        for(long i=1; i<=N; ++i){
            for(long j=1; j<=N; ++j){
                arr.add(i*j);
            }
        }

        Collections.sort(arr);
        System.out.println(arr.get(k-1));
        // 1 2 3
        // 2 4 6
        // 3 6 9
        // 1 2 2 3 3 4 6 6 9
    }
}

//import java.io.*;
//        import java.util.*;
//
//// BOJ 1300 K번째 수 <이분 탐색>
//public class boj1300 {
//    public void binarySearch(int a, int[] arr){
//        int l = 1;
//        int r = arr.length-1;
//        while(l<=r){
//            int mid = (l+r)/2;
//            if(mid == a){
//                arr[a]++;
//            }
//            else if(mid < a){
//                l = mid + 1;
//            }
//            else{
//                r = mid - 1;
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int k = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[k+1];
//        int count = 0;
//
//        for(long i=1; i<=N; ++i){
//            for(long j=1; j<=N; ++j){
//                if(i*j > k) continue;
//                arr[(int)i*(int)j]++;
//                count++;
//            }
//        }
//        count = 0;
//        for(int i=1; i<=k; ++i){
//            count += arr[i];
//            if(count >= k){
//                System.out.println(i);
//                break;
//            }
//        }
//        // 1  2  3  4  5  6
//        // 2  4  6  8 10 12
//        // 3  6  9 12 15 18
//        // 4  8 12 16 20 24
//        // 5 10 15 20 25 30
//        // 6 12 18 24 30 36
//    }
//}
