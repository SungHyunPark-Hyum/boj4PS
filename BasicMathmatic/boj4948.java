import java.io.*;
import java.util.*;

// BOJ 4948 베르트랑 공준 <기초 수학 2단계>
public class boj4948 {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static boolean[] visit;

    public static int count(int a, int b){
        int ret = 0;
        for(int i=a+1; i<=b; ++i){
            if(!visit[i]){
                ret++;
            }
        }
        return ret;
    }

    public static void eratos(int n){
        for(int i=2; i<=n/2; ++i){
            if(!visit[i]){
                int mul = 2;
                while(i * mul <= 2*n){
                    visit[i*mul] = true;
                    mul++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int max = -1;
        while(true){
            str = br.readLine();
            if(str.equals("0"))
                break;
            int N = Integer.parseInt(str);
            arr.add(N);
            max = max > N ? max : N;
        }
        visit = new boolean[2*max + 1];
        eratos(max);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.size(); ++i){
            int n = arr.get(i);
            sb.append(count(n, 2*n)).append("\n");
        }
        System.out.println(sb);
    }
}
