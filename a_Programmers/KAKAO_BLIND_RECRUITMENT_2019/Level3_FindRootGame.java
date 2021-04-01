package a_Programmers.KAKAO_BLIND_RECRUITMENT_2019;

import java.util.*;

public class Level3_FindRootGame {

    public int[][] solution(int[][] nodeinfo){

        int[][] answer = {};
        return answer;
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
