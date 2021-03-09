package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 2565 전깃줄
public class boj2565_TreeSet {
    public static int len;
    public static ArrayList<Node> lines;
    public static TreeSet<Integer> tree;

    public static int solution(ArrayList<Node> lines){
        tree = new TreeSet<Integer>();
        tree.add(lines.get(0).B);

        for(int i=1; i<lines.size(); ++i){
            int top = tree.last();
            int b = lines.get(i).B;

            if(top < b){
                tree.add(b);
            }
            else if(top > b){
                int rem = tree.ceiling(b);
                if(rem == b)
                    continue;
                tree.remove(rem);
                tree.add(b);
            }
            else
                continue;
        }
        return tree.size();
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
