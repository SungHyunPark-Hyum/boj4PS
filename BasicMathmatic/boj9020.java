import java.io.*;
import java.util.*;

// 시간 3696 ms
// BOJ 9020 골드바흐의 추측 <기본 수학 2단계>
public class boj9020 {
    public static ArrayList<Integer> prime = new ArrayList<>();
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void eratos(int n){
        for(int i=2; i<n/2; ++i){
            if(!visit[i]){
                int mul = 2;
                while(i * mul < n){
                    visit[i*mul] = true;
                    mul++;
                }
            }
        }
        for(int i=2; i<n; ++i){
            if(!visit[i])
                prime.add(i);
        }
    }

    public static void goldbach(int n){
        int a=-1, b=-1;
        for(int i=0; i<prime.size(); ++i){
            for(int j=prime.size()-1; j>=i; --j){
                int prime_i = prime.get(i);
                int prime_j = prime.get(j);
                if(prime_i + prime_j > n)
                    continue;
                if(prime_i + prime_j == n){
                    a = prime_i;
                    b = prime_j;
                }
            }
        }
        sb.append(a).append(" ").append(b).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int max = 2;
        for(int i=0; i<T; ++i){
            int n = Integer.parseInt(br.readLine());
            arr.add(n);
            max = max > n ? max : n;
        }
        visit = new boolean[max+1];
        eratos(max);
        for(int i=0; i<arr.size(); ++i){
            goldbach(arr.get(i));
        }
        System.out.println(sb);
    }
}