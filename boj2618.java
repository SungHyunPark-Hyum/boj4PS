import java.io.*;
import java.util.*;

// BOJ 2618 경찰차
public class boj2618 {
    public static Node p1;
    public static Node p2;
    public static int sum1 = 0, sum2 = 0, sum = 0;
    public static ArrayList<Integer> ans = new ArrayList<Integer>();
    public static StringBuilder sb = new StringBuilder();
    public static int[][] dp;
    public static int n, l;

    public static int calcDist(Node e, int x, int y){
        return (Math.abs(e.x-x) + Math.abs(e.y-y));
    }

    public static void calc(int x, int y, int i){
        int dist1 = calcDist(p1, x, y);
        int dist2 = calcDist(p2, x, y);
        if(dist1 < dist2){
            p1.update(x, y, i);
            dp[0][i] = dist1;
            ans.add(1);
            sum1 += dist1;
        }
        else if(dist1 > dist2){
            p2.update(x, y, i);
            dp[1][i] = dist2;
            ans.add(2);
            sum2 += dist2;
        }
        else {

        }
        sum = (sum1+sum2);
//        else if(dist1 > dist2){
//            p2.update(x, y, i);
//            dp[2][i] = dist1;
//            ans.add(2);
//        }

        if(i == l){
            sb.append(sum).append("\n");
            for(int j=0; j<ans.size(); ++j){
               sb.append(ans.get(j)).append("\n");
            }
            System.out.print(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        l = Integer.parseInt(br.readLine());

        StringTokenizer st;
        p1 = new Node(1, 1, 0);
        p2 = new Node(n, n, 0);
        dp = new int[2][n+1];
        for(int i=1; i<=l; ++i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            calc(x, y, i);
        }
        br.close();
    }

    public static class Node{
        int x, y, count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public void update(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
