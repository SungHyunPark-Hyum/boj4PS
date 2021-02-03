package Sorting;

import java.util.*;
import java.io.*;

// BOJ 1181 단어 정렬 <정렬 단계>
public class boj1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<String> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; ++i){
            String str = br.readLine();
            if(!arr.contains(str))
                arr.add(str);
        }

        Comparator<String> cmp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() != s2.length())
                    return s1.length() - s2.length();
                else
                    return s1.compareTo(s2);
            }
        };

        Collections.sort(arr, cmp);

        for(int i=0; i<arr.size(); ++i)
            sb.append(arr.get(i)).append("\n");

        System.out.println(sb);
    }
}
