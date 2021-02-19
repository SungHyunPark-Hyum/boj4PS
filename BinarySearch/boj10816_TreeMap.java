package BinarySearch;

import java.io.*;
import java.util.*;

// BOJ 10816 숫자 카드 2 <이분 탐색>
// with TreeMap
public class boj10816_TreeMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for(int i=0; i<N; ++i){
            int key = Integer.parseInt(st.nextToken());
            if(!tm.containsKey(key)){
                tm.put(key, 1);
            }
            else{
                tm.replace(key, tm.get(key) + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; ++i){
            int target = Integer.parseInt(st.nextToken());
            if(tm.containsKey(target)){
                sb.append(tm.get(target)).append(" ");
            }
            else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
