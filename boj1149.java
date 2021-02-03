import java.io.*;
import java.util.StringTokenizer;

// BOJ 1149 RGB거리 <동적 계획법 1>
public class boj1149 {
    public static int[][] house;

    public static void paint(int r, int g, int b, int i){
        house[i][0] = Math.min(house[i-1][1], house[i-1][2]) + r;
        house[i][1] = Math.min(house[i-1][2], house[i-1][0]) + g;
        house[i][2] = Math.min(house[i-1][0], house[i-1][1]) + b;
    }

    public static int get_ans(int n){
        return Math.min(Math.min(house[n-1][0], house[n-1][1]), house[n-1][2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        house = new int[N][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        house[0][0] = r; house[0][1] = g; house[0][2] = b;
        for(int i=1; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            paint(r, g, b, i);
        }
        System.out.println(get_ans(N));
    }
}
