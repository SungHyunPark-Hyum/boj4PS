package String;

import java.io.*;
import java.util.*;

// BOJ 1786 찾기
public class boj1786 {
    public static ArrayList<Integer> kmp(String T, String P, int[] pi){
        ArrayList<Integer> ret = new ArrayList<Integer>();

        int last = P.length();
        int j = 0;
        for(int i=0; i<T.length(); ++i){
            while(j>0 && T.charAt(i) != P.charAt(j)){
                j = pi[j-1];
            }

            if(T.charAt(i) == P.charAt(j)){
                if(j == last-1){
                    j = pi[j];
                    ret.add(i-last+1);
                }
                else{
                    j++;
                }
            }
        }

        return ret;
    }

    public static int[] getPi(String str){
        int[] pi = new int[str.length()];

        int j = 0;
        for(int i=1; i<str.length(); ++i){
            while(j>0 && str.charAt(i) != str.charAt(j)){
                j = pi[j-1];
            }

            if(str.charAt(i) == str.charAt(j)){
                pi[i] = ++j;
            }
        }
        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();

        int[] pi = getPi(P);
        ArrayList<Integer> answer = kmp(T, P, pi);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for(Integer a : answer)
            sb.append(a+1).append(" ");
        System.out.println(sb);
        br.close();
    }
}
