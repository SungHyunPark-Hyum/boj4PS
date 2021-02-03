import java.util.*;
import java.io.*;

// BOJ 11729 하노이 탑 이동 순서 <재귀 단계>

// Hanoi(n) = 2 * Hanoi(n-1) + 1
public class boj11729 {

    public static StringBuilder sb = new StringBuilder();
    public static int ans = 0;

    public static void hanoi(int n, int f, int m, int t){
        if(n == 1) {
            sb.append(f).append(" ").append(t).append("\n");
            ans++;
            return;
        }

        hanoi(n-1, f, t, m);

        sb.append(f).append(" ").append(t).append("\n");
        ans++;

        hanoi(n-1, m, f, t);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);
        System.out.println(ans);
        System.out.println(sb.toString());
    }
}
