package Greedy;

import java.io.*;
import java.util.*;

// BOJ 1700 멀티탭 스케줄링
public class boj1700 {
    public static ArrayList<Integer> arr;
    public static ArrayList<Integer> tab;
    public static HashMap<Integer, Integer> hm;
    public static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        tab = new ArrayList<>();
        hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
        }

        int count = 0;
        for(int i=0; i<k; ++i){
            int now = arr.get(i);
            if(!checkSame(now)){
                if(tab.size() >= n){
                    int outIndex = getOutIndex();
                    int out = tab.get(outIndex);
                    tab.remove(outIndex);
                    hm.put(out, i);
                    count++;
                }
                tab.add(now);
            }
            hm.put(now, getLastIndex(now, i));
        }
        System.out.println(count);
    }

    public static boolean checkSame(int n){
        if(tab.contains(n)) return true;
        return false;
    }

    public static int getLastIndex(int n, int start){
        for(int i=start+1; i<k; ++i){
            if(arr.get(i) == n){
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int getOutIndex(){
        int max = Integer.MIN_VALUE;
        int ret = 0;
        for(Integer e : tab){
            if(hm.get(e) > max){
                max = hm.get(e);
                ret = tab.indexOf(e);
            }
        }
        return ret;
    }
}
