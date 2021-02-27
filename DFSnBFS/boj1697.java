package DFSnBFS;

import java.io.*;
import java.util.*;

// BOJ 1697 숨바꼭질 <DFS와 BFS>
public class boj1697 {
    public static int N, K;
    public static boolean[] visit;

    public static void solution(int start){
        Queue<Node> q = new LinkedList<Node>();
        visit[start] = true;
        q.add(new Node(start, 0));
        while(!q.isEmpty()){
            Node e = q.poll();
            if(e.num == K) {
                System.out.println(e.count);
                break;
            }
            int[] next = getCalc(e.num);
            for(int i=0; i<3; ++i){
                if(check(next[i])){
                    visit[next[i]] = true;
                    q.add(new Node(next[i], e.count+1));
                }
            }
        }
    }

    public static boolean check(int a){
        if(a > 100000 || a < 0) return false;
        if(visit[a]) return false;
        return true;
    }

    public static int[] getCalc(int a){
        int[] ret = new int[3];
        ret[0] = a*2; ret[1] = a+1; ret[2] = a-1;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[100000+1];

        solution(N);
    }

    public static class Node{
        public int num, count;
        public Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
}
