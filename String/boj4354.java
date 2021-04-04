package String;

import java.io.*;
import java.util.*;

// BOJ 4354 문자열 제곱
public class boj4354 {
    public static StringBuilder sb = new StringBuilder();
    public static void getPi(String str){
        int[] pi = new int[str.length()];
        char[] cArr  = str.toCharArray();
        int len = str.length();

        int j = 0;
        for(int i=1; i<len; ++i){
            while(j>0 && cArr[i] != cArr[j]){
                j = pi[j-1];
            }

            if(cArr[i] == cArr[j]){
                pi[i] = ++j;
            }
        }
        int div = pi[len-1];
        if(len%(len-div) == 0)
            sb.append(len/(len-div)).append("\n");
        else
            sb.append(1).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        while(T-- > 0){
            String str = br.readLine();
            if(str.equals(".")){
                break;
            }

            getPi(str);
        }
        System.out.println(sb);
        br.close();
    }
}
