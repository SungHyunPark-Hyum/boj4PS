package Stack_Queue_Deque;

import java.io.*;
import java.util.*;

// BOJ 5430 AC
public class boj5430 {
    public static StringBuilder sb;

    public static void func(String str, String opr){
        Deque<String> dq = new LinkedList<String>();
        sb = new StringBuilder();
        String[] arr = str.split("\\[|\\]|,");

        for(int i=1; i<arr.length; i++){
            dq.add(arr[i]);
        }
        // if flag == 1 -> acs
        // if flag == -1  -> desc
        int flag = 1;
        for(int i=0; i<opr.length(); ++i){
            if(opr.charAt(i) == 'R'){
                flag *= -1;
            }
            else{
                if(dq.isEmpty()){
                    sb.append("error");
                    System.out.println(sb);
                    return;
                }
                if(flag == 1) dq.pollFirst();
                else dq.pollLast();
            }
        }
        sb.append("[");
        if(flag == 1){
            while(!dq.isEmpty()){
                sb.append(dq.pollFirst()).append(",");
            }
        }else{
            while(!dq.isEmpty()){
                sb.append(dq.pollLast()).append(",");
            }
        }
        int lastIdx = sb.lastIndexOf(",");
        if(lastIdx == -1){
            System.out.println("[]");
            return;
        }
        sb.replace(lastIdx, lastIdx+1, "]");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int l=0; l<T; ++l){
            String opr = br.readLine();
            int n = Integer.parseInt(br.readLine());
            func(br.readLine(), opr);
        }
    }
}
