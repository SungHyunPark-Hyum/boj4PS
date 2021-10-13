import java.util.*;

class Solution {
    public Node root;
    public Queue<String> ans;

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        Solution start = new Solution();
        start.solution(orders, course);
    }

    public String[] solution(String[] orders, int[] course) {
        System.out.println("start solution function");
        this.init();
        for(int i=0; i<orders[0].length(); ++i){
            this.dfs(orders[0], 0, i, 2, this.root);
        }
        for(int i=0; i<root.children.size(); ++i){
            this.print(0, root, 2);
        }
        String[] answer = {};
        return answer;
    }

    public void print(int depth, Node parent, int count){
        if(depth == count){
            return;
        }
        for(int i=0; i<depth-1; ++i){
            System.out.print("\t");
        }
        System.out.println(parent.data);
        for(Node child : parent.children){
            print(depth+1, child, count);
        }
    }

    public void init(){
        this.root = new Node("", ' ');
        this.ans = new LinkedList<String>();
        this.ans.add("");
    }

    public void dfs(String str, int depth, int index, int count, Node parent){
        if(depth == count){
            int max = ans.peek().length();

            if(parent.len == max){
                ans.add(parent.str);
            }
            else if(parent.len > max){
                while(!ans.isEmpty()){
                    ans.poll();
                }
                ans.add(parent.str);
            }

            return;
        }

        for(int i=index; i<str.length(); ++i){
            boolean exist = false;
            if(!parent.children.isEmpty()){
                for(Node child : parent.children){
                    if(child.data == str.charAt(i)){
                        exist = true;
                        dfs(str, depth+1, index+1, count, child);
                        break;
                    }
                }
            }

            if(!exist){
                Node e = new Node(parent.str, str.charAt(i));
                parent.children.add(e);
                dfs(e.str, depth+1, index+1, count, e);
            }
        }
    }

    public class Node{
        String str;
        char data;
        int len;
        int count;
        ArrayList<Node> children;

        public Node(String str, char data){
            this.str = str + data;
            this.data = data;
            this.len = str.length();
            this.count = 1;
            this.children = new ArrayList<Node>();
        }
    }
    // A B C D E
    // A B
    // C D
    // A D E
    // X Y Z
    // X Y Z
    // A C D

    // A : B2, C2, D3, E2
    // B : 
}