import java.io.*;
import java.util.*;

// BOJ 1929 소수 구하기 <기본 수학 2단계>
public class boj1929 {
    public static boolean[] visit;

    public static void eratosthenes(int n){
        for(int i=2; i<n; ++i){
            if(visit[i])
                continue;
            int mul = 2;
            while(i*mul <= n){
                visit[i*mul] = true;
                mul++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        visit[1] = true;

        eratosthenes(N);
        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; ++i){
            if(!visit[i])
                sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
