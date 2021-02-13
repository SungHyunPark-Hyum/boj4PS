package TheRest;

import java.io.*;

// BOJ 2941 크로아티아 알파벳 <문자열>..
public class boj2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "!");
        System.out.println(str.length());
    }
}
