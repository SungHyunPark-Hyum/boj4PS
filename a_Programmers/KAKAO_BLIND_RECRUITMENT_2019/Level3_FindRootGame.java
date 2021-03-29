package a_Programmers.KAKAO_BLIND_RECRUITMENT_2019;

import java.util.*;

public class Level3_FindRootGame {

    public static int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> arr = new ArrayList<Node>();
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();

        vertices.add(new Vertex(-1, -1));
        for(int i=0; i<nodeinfo.length; ++i){
            arr.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
            vertices.add(new Vertex(nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(arr, new Comparator<Node>(){
            @Override
            public int compare(Node e1, Node e2){
                if(e1.y == e2.y)
                    return e1.x - e2.x;
                return e2.y - e1.y;
            }
        });

        int[][] answer = {};
        return answer;
    }


    public static void main(String[] args) {
        Level3_FindRootGame frg = new Level3_FindRootGame();
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] ret = solution(nodeinfo);
        for(int i=0; i<2; ++i){
            for(int j=0; j<nodeinfo.length; ++j){
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class Node{
        int x, y, num;
        public Node(int x, int y, int i){
            this.x = x;
            this.y = y;
            this.num = i;
        }
    }

    public static class Vertex{
        int x, y;
        public Vertex(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
