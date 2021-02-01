import java.io.*;
import java.util.*;

// 시간 176 ms
// BOJ 9020 골드바흐의 추측 <기본 수학 2단계>
public class boj9020_TreeMap {
    public static ArrayList<Integer> prime = new ArrayList<>();
    public static TreeMap<Integer, Integer> tm = new TreeMap<>();
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void eratos(int n) {
        for (int i = 2; i < n / 2; ++i) {
            if (!visit[i]) {
                int mul = 2;
                while (i * mul < n) {
                    visit[i * mul] = true;
                    mul++;
                }
            }
        }
        int ii = 0;
        for (int i = 2; i < n; ++i) {
            if (!visit[i]) {
                prime.add(i);
                tm.put(i, ii++);
            }
        }

    }

    public static void goldbach(int n) throws IOException {
        int a = n / 2, b = n / 2;
        if (!visit[a] && !visit[b]) {
            //sb.append(a).append(" ").append(b).append("\n");
            bw.write(a + " " + b + "\n");
        } else {
            a = tm.floorEntry(n / 2).getValue();
            b = tm.ceilingEntry(n / 2).getValue();

            int sum = prime.get(a) + prime.get(b);
            while (sum != n) {
                if (sum > n) {
                    a--;
                } else {
                    b++;
                }
                sum = prime.get(a) + prime.get(b);
            }
            //sb.append(prime.get(a)).append(" ").append(prime.get(b)).append("\n");
            bw.write(prime.get(a) + " " + prime.get(b) + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int max = 2;
        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine());
            arr.add(n);
            max = max > n ? max : n;
        }
        visit = new boolean[max + 1];
        eratos(max);
        for (int i = 0; i < arr.size(); ++i) {
            goldbach(arr.get(i));
        }
//        System.out.println(sb);
        bw.flush();
        bw.close(); br.close();
    }
}