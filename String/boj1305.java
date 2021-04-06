package String;

import java.io.*;
import java.util.*;

// BOJ 1305 광고
public class boj1305 {
    public static void solution(int n, String str){
        System.out.println(n - getPi(str));
    }

    public static int getPi(String str){
        int len = str.length();
        int[] pi = new int[len];
        char[] cArr = str.toCharArray();

        int j = 0;
        for(int i=1; i<len; ++i){
            while(j>0 && cArr[i] != cArr[j])
                j = pi[j-1];

            if(cArr[i] == cArr[j])
                pi[i] = ++j;
        }

        return pi[len-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        solution(n, str);
    }
}
