package BasicMathmatic;

import java.util.*;
import java.io.*;

// BOJ 1712 손인북기점 <기본 수학 1단계> Basic Mathematics 1
public class boj1712 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        int cnt = 1;
        if(B >= C){
            System.out.println(-1);
            return;
        }

        if(A + B * cnt < C * cnt){
            System.out.println(1);
            return;
        }

        while(A + B * cnt > C * cnt){
            cnt++;
        }

        if(A + B * cnt == C * cnt)
            System.out.println(++cnt);
        else
            System.out.println(cnt);
    }
}
