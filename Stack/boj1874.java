package Stack;

import java.io.*;
import java.util.*;

// BOJ 1874 스택 수열 <스택>
public class boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        for(int i=0; i<n; ++i){
            seq[i] = Integer.parseInt(br.readLine());
        }

        boolean flag = false;
        int num = 1;
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(true){
            if(i == n){
                break;
            }
            if(stk.peek() < seq[i]){
                stk.push(num++);
                sb.append('+').append('\n');
            }
            else if(stk.peek() == seq[i]){
                stk.pop();
                sb.append('-').append('\n');
                i++;
            }
            else{
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println(sb);
        br.close();
    }
}