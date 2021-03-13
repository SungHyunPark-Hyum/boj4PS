package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 9019 DSLR
public class boj9019 {
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void solution(int from, int to){
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(from, ""));
        visit[from] = true;

        while(!q.isEmpty()){
            Node e = q.poll();
            if(e.num == to){
                sb.append(e.log).append("\n");
                return;
            }

            int[] next = DSLR(e.num);
            for(int i=0; i<4; ++i){
                if(!visit[next[i]]){
                    visit[next[i]] = true;
                    q.add(new Node(next[i], e.log.concat(addLog(i))));
                }
            }
        }
    }

    public static String addLog(int flag){
        switch(flag)
        {
            case 0 : return "D";
            case 1 : return "S";
            case 2 : return "L";
            case 3 : return "R";
        }
        return "";
    }

    public static int[] DSLR(int a){
        int[] ret = new int[4];
        ret[0] = (a*2)%10000;

        if(a == 0) ret[1] = 9999;
        else ret[1] = a-1;

        int d1 = a/1000;
        ret[2] = (a-d1*1000)*10 + d1;

        int d4 = a%10;
        ret[3] = a/10 + d4*1000;

        return ret;
    }

    public static boolean isPossible(int a) {
        if(visit[a]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            visit = new boolean[10001];
            solution(from, to);
        }
        System.out.println(sb);
        br.close();
    }

    public static class Node{
        int num; String log;
        public Node(int num, String log){
            this.num = num;
            this.log = log;
        }
    }
}
