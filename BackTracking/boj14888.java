package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 14888 연산자 끼워넣기 <백트래킹 단계>
public class boj14888 {
    public static int[] nums;
    public static int[] operator;
    public static int N;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static int func(int a, int b, int opr) {
        switch (opr) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3: {
                if (b > 0 && a < 0){
                    a *= -1;
                    int ret = a/b;
                    return ret * -1;
                }
                return a / b;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static boolean isPossible(int a) {
        if (a == 0) return false;
        else return true;
    }

    public static void dfs(int a, int sum) {
        if (a == N-1) {
            max = max > sum ? max : sum;
            min = min < sum ? min : sum;
            return;
        }

        int now = nums[a+1];
        for (int j = 0; j < 4; ++j) {
            if (isPossible(operator[j])) {
                operator[j]--;
                dfs(a + 1, func(sum, now, j));
                operator[j]++;
            }
        }
    }

    // addition, subtraction, multiplication, division
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        operator = new int[4];

        for (int i = 0; i < N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i)
            operator[i] = Integer.parseInt(st.nextToken());

        dfs(0, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
}
