package a_Programmers.WeeklyChallenge;

import java.util.*;

public class Week9 {

    class Solution {
        public boolean[] visited;
        public ArrayList<Integer>[] tree;
        public int n;

        public int solution(int n, int[][] wires) {
            this.n = n;

            tree = new ArrayList[n+1];
            for(int i=0; i<=n; ++i){
                tree[i] = new ArrayList<Integer>();
            }

            for(int[] wire : wires){
                this.tree[wire[0]].add(wire[1]);
                this.tree[wire[1]].add(wire[0]);
            }

            int total = wires.length;
            int answer = Integer.MAX_VALUE;

            for(int[] wire : wires){
                init();
                visited[wire[0]] = visited[wire[1]] = true;
                int sum = dfs(wire[0]);
                answer = Math.min(answer, Math.abs(n-2*sum));
            }

            return answer;
        }

        public int dfs(int a){

            int sum = 1;
            for(Integer e : tree[a]){
                if(!visited[e]){
                    visited[e] = true;
                    sum += dfs(e);
                }
            }

            return sum;
        }

        public void init(){
            this.visited = new boolean[n+1];
        }
    }
}
