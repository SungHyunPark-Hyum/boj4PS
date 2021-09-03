package a_Programmers;

import java.util.*;

class Level3_FarthestNode {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i=1; i<=n; ++i){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edge.length; ++i){
            int from = edge[i][0];
            int to = edge[i][1];

            arr[from].add(to);
            arr[to].add(from);
        }

        Comparator<Node> cmp = new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return n1.dist - n2.dist;
            }
        };

        PriorityQueue<Node> pq = new PriorityQueue<Node>(cmp);
        int[] result = new int[n+1];
        for(Integer e : arr[1]){
            pq.add(new Node(1, e, 1));
        }
        result[1] = 0;

        int max = Integer.MIN_VALUE;
        int count = 1;
        while(count != n){
            Node e = pq.poll();
            if(result[e.to] != 0) continue;
            result[e.to] = e.dist;
            count++;
            max = Math.max(e.dist, max);

            for(Integer child : arr[e.to]){
                if(child != 1 && result[child] == 0){
                    pq.add(new Node(e.to, child, result[e.to] + 1));
                }
            }
        }

        for(int i=2; i<=n; ++i){
            if(result[i] == max)
                answer++;
        }

        return answer;
    }

    public class Node{
        int from, to, dist;
        public Node(int f, int t, int d){
            this.from = f;
            this.to = t;
            this.dist = d;
        }
    }
}