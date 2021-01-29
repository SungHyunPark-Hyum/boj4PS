import java.io.*;

// BOJ 1193 분수찾기 <기본 수학 1단계>
public class boj1193 {

    public static void func(int x){
        int an = 1;
        int sum = 1;
        while(sum < x){
            an++;
            sum += an;
        }
        int cnt;
        if(an%2 == 0)
            cnt = x - sum + an;
        else
            cnt = sum - x + 1;
        int up = 1; int down = an;
        while(cnt > 1){
            up++;
            down --;
            cnt--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(up).append("/").append(down);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        func(X);
    }
}
