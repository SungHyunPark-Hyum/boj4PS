package Greedy;

import java.io.*;
import java.util.StringTokenizer;

// BOJ 1541 잃어버린 괄호 <그리디 알고리즘>
public class boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer nums = new StringTokenizer(str, "+|-");
        String oprs = str.replaceAll("[0-9]", "");
        int sum = Integer.parseInt(nums.nextToken());
        boolean flag = false;
        for(int i=0; i<oprs.length(); ++i){
            if(oprs.charAt(i) == '+'){
                if(!flag){
                    sum += Integer.parseInt(nums.nextToken());
                }
                else{
                    sum -= Integer.parseInt(nums.nextToken());
                }
            }
            else{
                flag = true;
                sum -= Integer.parseInt(nums.nextToken());
            }
        }
        System.out.println(sum);
    }
}
