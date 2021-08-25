package a_Programmers.KAKAO_BLIND_RECRUITMENT_2019;

import java.util.*;

public class Level3_FindRootGame {
    public int[][] answer;
    public int index;

    public int[][] solution(int[][] nodeinfo){
        answer = new int[2][nodeinfo.length];

        ArrayList<Node> data = new ArrayList<Node>();
        for(int i=0; i<nodeinfo.length; ++i){
            data.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }

        Collections.sort(data, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y == o2.y)
                    return o1.x - o2.x;
                return o2.y - o1.y;
            }
        });

        Node root = new Node(data.get(0).x, data.get(0).y, data.get(0).num);
        for(int i=1; i<data.size(); ++i){
            setChild(root, new Node(data.get(i).x, data.get(i).y, data.get(i).num));
        }

        index = 0;
        preOrder(root);
        index = 0;
        postOrder(root);

        return answer;
    }

    public void preOrder(Node root){
        if(root == null)
            return;
        answer[0][index++] = root.num;
        preOrder(root.lChild);
        preOrder(root.rChild);
    }

    public void postOrder(Node root){
        if(root == null)
            return;
        postOrder(root.lChild);
        postOrder(root.rChild);
        answer[1][index++] = root.num;
    }

    public void setChild(Node root, Node node){
        boolean flag = false;
        while(!flag){
            if(root.x > node.x){
                if(root.lChild == null){
                    root.lChild = node;
                    flag = true;
                }
                else{
                    root = root.lChild;
                }
            }
            else{
                if(root.rChild == null){
                    root.rChild = node;
                    flag = true;
                }
                else{
                    root = root.rChild;
                }
            }
        }
    }

    public class Node{
        int x, y, num;
        Node lChild;
        Node rChild;
        public Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
            lChild = rChild = null;
        }
    }

    public static void main(String[] args) {
        Level3_FindRootGame frg = new Level3_FindRootGame();
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] ret = frg.solution(nodeinfo);
        for(int i=0; i<2; ++i){
            for(int j=0; j<nodeinfo.length; ++j){
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }
}
