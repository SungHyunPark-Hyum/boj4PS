import java.util.*;
import java.io.*;

// BOJ10989 <정렬 단계> <Counting Sort>
public class boj10989_sorting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        int max = 0;
        for(int i=1; i<=N; ++i) {
            int n = Integer.parseInt(br.readLine());
            count[n]++;
            max = max > n ? max : n;
        }

        for(int i=2; i<=max; ++i) {
            count[i] += count[i-1];
        }

        int idx = 1;
        for(int i=1; i<=max; ++i){
            if(count[i] != count[i-1]){
                for(int j=idx; j<=count[i]; ++j){
                    sb.append(i).append("\n");
                }
                idx = count[i]+1;
            }
        }
        System.out.println(sb.toString());
    }
}
