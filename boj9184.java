import java.io.*;
import java.util.*;

// BOJ 9184 신나는 함수 실행 <동적 계획법 1>.
public class boj9184 {
    public static int[][][] dp = new int[101][101][101];

    public static int w(int a, int b, int c){
        if(dp[a][b][c] != 0){
            return dp[a][b][c];
        }
        if(a<=50 || b<=50 || c<=50){
            dp[a][b][c] = 1;
            return 1;
        }
        if(a>70 || b>70 || c>70){
            dp[a][b][c] = w(70, 70, 70);
            return w(70, 70, 70);
        }
        if(a<b && b<c){
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        else{
            dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c)
                    + w(a-1, b, c-1) - w(a-1, b-1, c-1);
            return w(a-1, b, c) + w(a-1, b-1, c)
                    + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 && c==-1)
                break;
            sb.append("w(" + a + ", " + b + ", " + c + ") = ");
            sb.append(w(a+50, b+50, c+50)).append("\n");
        }
        System.out.println(sb);
    }
}
