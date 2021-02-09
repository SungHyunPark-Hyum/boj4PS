package Stack;

import java.io.*;
import java.util.*;

// BOJ 4949 균형잡힌 세상 <스택>
public class boj4949 {

    public static boolean func(String str) {
        String sentence = str;
        int len = sentence.length() - 1;
        Stack<Character> stk = new Stack<Character>();
        for (int i = 0; i < len; ++i) {
            char tmp = sentence.charAt(i);
            if (tmp == '(') stk.push(tmp);
            else if (tmp == '[') stk.push(tmp);
            else if (tmp == ')') {
                if(stk.isEmpty())
                    return false;
                char pair = stk.pop();
                if(pair != '(') return false;
            }
            else if (tmp == ']') {
                if(stk.isEmpty()) return false;
                char pair = stk.pop();
                if(pair != '[') return false;
            }
            else {

            }
        }
        if(!stk.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (true) {
            str = br.readLine();
            if (str.equals("."))
                break;
            if(func(str)) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
