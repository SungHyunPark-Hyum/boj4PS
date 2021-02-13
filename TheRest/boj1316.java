package TheRest;

import java.io.*;
import java.util.*;

// BOJ 1316 그룹 단어 체커 <문자열>
public class boj1316 {
    public static int sum = 0;

    public static void func(String str){
        char compare = ' ';
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i<str.length(); ++i){
            char now = str.charAt(i);
            if(now != compare){
                if(set.contains(now)){
                    return;
                }
                set.add(now);
                compare = now;
            }
        }
        sum++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int l=0; l<N; ++l){
            String target = br.readLine();
            func(target);
        }
        System.out.println(sum);
    }
}
