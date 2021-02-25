import java.io.*;
import java.util.*;

// BOJ 1300 K번째 수 <이분 탐색>
public class boj1300 {
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
        // 1  2  3  4  5
        // 2  4  6  8 10
        // 3  6  9 12 15
        // 4  8 12 16 20
        // 5 10 15 20 25
    }
}
