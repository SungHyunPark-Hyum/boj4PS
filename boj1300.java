import java.io.*;
import java.util.*;

// BOJ 1300 K번째 수 <이분 탐색>
public class boj1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        for(long i=1; i<=N; ++i){
            for(long j=1; j<=N; ++j){

            }
        }
        // 1  2  3  4  5  6
        // 2  4  6  8 10 12
        // 3  6  9 12 15 18
        // 4  8 12 16 20 24
        // 5 10 15 20 25 30
        // 6 12 18 24 30 36

        // k = 13 -> 9
        // 1  2  3  4
        // 2  4  6  8
        // 3  6  9 12
        // 4  8 12 16
    }
}
