package BruteForce;

import java.util.*;
import java.io.*;

//
//BOJ_1436 영화감독 숌 <브루트포스>
public class boj1436 {

    public static boolean func(int a){
        boolean ret = false;
        String tmp = Integer.toString(a);
        if(tmp.contains("666"))
            ret = true;
        return ret;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int start = 666;
        int cnt = 1;
        while(cnt != n){
            start++;
            if(func(start))
                cnt++;
        }
        System.out.println(start);
    }
}