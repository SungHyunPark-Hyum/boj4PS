package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 9251 LCS <동적 계획법>
// ACAYKP
// CAPCAK
// -> ACAK
public class boj9251 {
    public static void solution(String str1, String str2){
        int[][] dp = new int[str2.length()+1][str1.length()+1];
        for(int i=0; i<str2.length(); ++i){
            for(int j=0; j<str1.length(); ++j){
                if(str2.charAt(i) == str1.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[str2.length()][str1.length()]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        solution(str1, str2);
    }
}
