package TwoPointer;

import java.io.*;
import java.util.*;

// BOJ 3273 두 수의 합 <투 포인터>
public class boj3273 {
    public static int n;
    public static ArrayList<Node> arr;

    public static void solution(int target){
        int l = 0;
        int r = n-1;
        int ans = 0;
        while(l<r){
            int tmp = arr.get(l).num + arr.get(r).num;
            if(tmp == target){
                ans++;
                l++; r--;
            }
            else if(tmp > target){
                r--;
            }
            else{
                l++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        for(int i=0; i<n; ++i){
            int a = Integer.parseInt(st.nextToken());
            arr.add(new Node(a, i));
        }
        int target = Integer.parseInt(br.readLine());

        Collections.sort(arr, new Comparator<Node>(){
            @Override
            public int compare(Node e1, Node e2){
                return e1.num - e2.num;
            }
        });

        solution(target);
    }

    public static class Node{
        public int num, idx;
        public Node(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }
}
