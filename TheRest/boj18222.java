package TheRest;

import java.io.*;
import java.util.*;

// BOj 18222 투에-모스 문자열
public class boj18222 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "0110100110010110";
        long k = Long.parseLong(br.readLine());
        long tmp = (long)Math.pow(2, 59);
        boolean reverse = false;
        while(k > 16){
            if(k > tmp){
                k -= tmp;
                reverse = !reverse;
            }
            tmp /= 2;
        }
        char add = str.charAt((int)(k-1));
        if(reverse){
            if(add == '1') add = '0';
            else add = '1';
        }
        System.out.println(add);
    }
}
