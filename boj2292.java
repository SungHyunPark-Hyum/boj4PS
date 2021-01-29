import java.io.*;
import java.util.StringTokenizer;

// BOj 2292 벌집 <기본 수학 1단계>
public class boj2292 {
    public static int func(int n){
        int a = 0;
        int sum = 1 + a * 6;
        while(sum < n){
            a++;
            sum += a * 6;
        }
        return a;
    }
    // 1
    // 6 : 2 ~ 7
    // 12: 8 ~ 19
    // 18 : 20 ~ 37
    // 24 : 38 ~ 61

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(func(N) + 1);
    }
}
