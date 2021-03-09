package DynamicProgramming;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// BOJ 2565 전깃줄
public class boj2565_UpperBound {
    public static int len;
    public static ArrayList<Node> lines;

    public static int upperBound(int a, ArrayList<Integer> ret) {
        int l = 0;
        int r = ret.size();

        while(l<r){
            int mid = (l+r)/2;
            if(ret.get(mid) <= a){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }

    public static int solution(ArrayList<Node> lines){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(lines.get(0).B);

        for(int i=1; i<lines.size(); ++i){
            int last = ret.get(ret.size()-1);
            int b = lines.get(i).B;
            if(last < b){
                ret.add(b);
            }
            else if(last > b){
                int upper_idx = upperBound(b, ret);
                if(upper_idx == 0){
                    ret.set(upper_idx, b);
                    continue;
                }
                if(ret.get(upper_idx -1) != b){
                    ret.set(upper_idx, b);
                }
            }
            else{
                continue;
            }
        }
        return ret.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        lines = new ArrayList<Node>();
        StringTokenizer st;
        int loop = len;
        while(loop-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines.add(new Node(a, b));
        }

        Collections.sort(lines, new Comparator<Node>(){
            @Override
            public int compare(Node e1, Node e2){
                return e1.A - e2.A;
            }
        });

        System.out.println(len - solution(lines));
    }

    public static class Node{
        int A, B;

        public Node(int A, int B){
            this.A = A;
            this.B = B;
        }
    }
}
