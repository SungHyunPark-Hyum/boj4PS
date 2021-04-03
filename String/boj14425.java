package String;

import java.io.*;
import java.util.*;

// BOJ 14425 문자열 집합
public class boj14425 {
    public static int answer = 0;
    public static String str;
    public static void setNode(Node root, int index, int len){
        if(index == len) {
            root.isLast = true;
            return;
        }

        int idx = str.charAt(index) - 'a';
        if(root.child[idx] == null){
            root.child[idx] = new Node(str.charAt(index));
        }
        root = root.child[idx];
        setNode(root, index+1, len);
    }

    public static void dfs(Node root, int index, int len){
        if(index == len){
            if(root.isLast)
                answer++;
            return;
        }

        char ch = str.charAt(index);
        if(root.child[ch - 'a'] != null){
            root = root.child[ch - 'a'];
            dfs(root, index+1, len);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node root = new Node(' ');
        str = null;
        while(N-- > 0){
            str = br.readLine();
            setNode(root, 0, str.length());
        }

        while(M-- > 0){
            str = br.readLine();
            dfs(root, 0, str.length());
        }

        System.out.println(answer);
        br.close();
    }

    public static class Node{
        char data;
        Node[] child;
        boolean isLast;

        public Node(char data){
            this.data = data;
            this.child = new Node[26];
            this.isLast = false;
        }
    }
}
