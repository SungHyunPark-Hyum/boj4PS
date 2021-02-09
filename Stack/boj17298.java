package Stack;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ 17298 오큰수 <스택>
public class boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[N];
        Stack<Node> stk = new Stack<Node>();
        StringBuilder sb = new StringBuilder();
        stk.push(new Node(arr[0], 0));
        for (int i = 1; i < N; ++i) {
            while (stk.peek().num < arr[i]) {
                Node e = stk.pop();

                ans[e.idx] = arr[i];
                if (stk.isEmpty())
                    break;
            }
            stk.push(new Node(arr[i], i));
        }
        for (int i = 0; i < N; ++i) {
            if (ans[i] == 0)
                sb.append(-1).append(" ");
            else
                sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
    // 3  5  2  9  7  2
    // 5  9  9 -1 -1 -1

    public static class Node {
        public int num, idx;

        public Node(int n, int i) {
            this.num = n;
            this.idx = i;
        }
    }
}
