package BasicMathmatic;

import java.io.*;

// BOJ 2581 소수 <기본 수학 2단계>
public class boj2581 {

    public static boolean prime(int n){
        if(n == 1)
            return false;
        if(n == 2 || n == 3)
            return true;
        for(int i=2; i<=(int)Math.sqrt((double)n); ++i){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static void func(int m, int n){
        int sum = 0;
        int min = -1;
        for(int i=n; i>=m; --i){
            if(prime(i)){
                sum+= i;
                min = i;
            }
        }
        if(sum == 0)
            System.out.println(min);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        func(M, N);
    }
}
