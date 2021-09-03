package a_Programmers;

import java.util.*;

class Level2_MaximizeFormulas {
    public int[] parent;
    public long[] result;
    public boolean[] visited;
    public ArrayList<ArrayList<Integer>> index;
    public ArrayList<Character> ops;
    public long answer = 0;
    public int len;
    public String[] arr;

    public long solution(String expression) {

        arr = expression.split("[^0-9]");
        len = arr.length;

        this.init();
        visited = new boolean[len];
        ops = new ArrayList<Character>();
        index = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<3; ++i) {
            index.add(new ArrayList<>());
        }

        int count = 0;
        for(int i=0; i<expression.length(); ++i){
            char tmp = expression.charAt(i);
            if(tmp == '+' || tmp == '-' || tmp == '*'){
                int idx = ops2Index(tmp);
                ops.add(tmp);
                index.get(idx).add(count++);
            }
        }

        dfs(0, new ArrayList<Integer>());

        return Math.abs(answer);
    }

    public void init(){
        parent = new int[len];
        for(int i=0; i<len; ++i)
            parent[i] = i;

        result = new long[len];

        for(int i=0; i<len; ++i){
            result[i] = Long.parseLong(arr[i]);
        }
    }

    public void dfs(int depth, ArrayList<Integer> arr){
        if(depth == 3){
            for(Integer e : arr){
                for(Integer ee : index.get(e)){
                    calc(index2Ops(e), ee);
                }
            }
            answer = Math.max(Math.abs(result[find(0)]), answer);
            init();
            return;
        }

        for(int i=0; i<3; ++i){
            if(!visited[i]){
                visited[i] = true;
                arr.add(i);
                dfs(depth+1, arr);
                visited[i] = false;
                arr.remove(arr.indexOf(i));
            }
        }
    }

    public int ops2Index(char op){
        switch(op){
            case '+' : return 0;
            case '-' : return 1;
            case '*' : return 2;
            default : return -1;
        }
    }

    public char index2Ops(int idx){
        switch(idx){
            case 0 : return '+';
            case 1 : return '-';
            case 2 : return '*';
            default : return '0';
        }
    }

    public void calc(char op, int indexOfOps){
        int pa = find(indexOfOps);
        int pb = find(indexOfOps+1);

        long tmp1 = result[pa];
        long tmp2 = result[pb];

        long ret;
        switch(op){
            case '+' :{
                ret = tmp1 + tmp2;
                break;
            }
            case '-' :{
                ret = tmp1 - tmp2;
                break;
            }
            case '*' :{
                ret = tmp1 * tmp2;
                break;
            }
            default :{
                ret = -1;
                break;
            }
        }
        union(indexOfOps, indexOfOps+1);
        result[pb] = ret;
    }

    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb)
            return;

        parent[pa] = pb;
        return;
    }

    public int find(int a){
        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }
}