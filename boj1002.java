import java.io.*;
import java.util.*;

// BOJ 1002 터렛 <기본 수학 2단계>
public class boj1002 {
    public static int func(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance_pow = (int)Math.pow((x1 - x2), 2) + (int)Math.pow((y1 - y2), 2);

        // 일치
        if (x1 == x2 && y1 == y2 && r1 == r2)
            return -1;
        // 외접
        else if (distance_pow == Math.pow(r1 + r2, 2))
            return 1;
        // 내접
        else if (Math.pow(r1 - r2, 2) == distance_pow)
            return 1;
        // 내부에서 떨어져 있을 때
        else if (Math.pow(r1 - r2, 2) > distance_pow)
            return 0;
        // 외부에서 떨어져 있을 떄
        else if (distance_pow > Math.pow(r1 + r2, 2))
            return 0;
        else
            return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; ++i) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            System.out.println(func(x1, y1, r1, x2, y2, r2));
        }
    }
}
