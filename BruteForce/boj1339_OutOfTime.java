package BruteForce;

import java.io.*;
import java.util.*;

// BOJ 1339 단어 수학
public class boj1339_OutOfTime {
    public static HashMap<Character, Integer> hm;
    public static int len;
    public static ArrayList<String> arr;
    public static ArrayList<Character> alphabet;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hm = new HashMap<Character, Integer>();
        arr = new ArrayList<String>();
        alphabet = new ArrayList<Character>();

        while(n-- > 0){
            String str = br.readLine();
            arr.add(str);
            for(int i=0; i<str.length(); ++i){
                if(hm.containsKey(str.charAt(i))) continue;
                hm.put(str.charAt(i), -1);
                alphabet.add(str.charAt(i));
            }
        }

        len = alphabet.size();

        boolean[] visited = new boolean[10];
        dfs(0, visited);

        System.out.println(max);
    }

    public static void dfs(int a, boolean[] visited){
        if(a == len){
            calc();
            return;
        }

        for(int i=0; i<10; ++i){
            if(visited[i]){
                continue;
            }
            else {
                visited[i] = true;
                hm.put(alphabet.get(a), i);
                dfs(a+1, visited);
                visited[i] = false;
            }
        }
    }

    public static void calc(){
        int ans = 0;
        for(String str : arr){
            String tmp = str;
            for(int i=0; i<alphabet.size(); ++i){
                tmp = tmp.replace(alphabet.get(i), Integer.toString(hm.get(alphabet.get(i))).charAt(0));
            }
            ans += Integer.parseInt(tmp);
        }
        max = Math.max(max, ans);
    }
}
