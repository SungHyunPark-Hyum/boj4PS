package BasicMathmatic;

import java.io.*;

// BOJ 2839 설탕 배달 <기본 수학 1단계>
public class boj2839 {
    public static void func(int n){
        int five_num = n/5;
        int ans = -1;

        while(ans == -1 && five_num >= 0){
            int tmp = n - 5 * five_num;
            if(tmp % 3 == 0){
                ans = (tmp/3) + five_num;
            }
            five_num--;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        func(N);
    }
}
