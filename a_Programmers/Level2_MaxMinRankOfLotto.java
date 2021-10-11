package a_Programmers;

import java.util.*;

public class Level2_MaxMinRankOfLotto {

    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {

            ArrayList<Integer> win = new ArrayList<Integer>();
            for(int i=0; i<win_nums.length; ++i){
                win.add(win_nums[i]);
            }

            int count = 0;
            int zeros = 0;
            for(int i=0; i<lottos.length; ++i){
                if(lottos[i] == 0){
                    zeros++;
                    continue;
                }
                if(win.contains(lottos[i]))
                    count++;
            }

            int[] answer = new int[2];
            answer[0] = get_rank(zeros + count);
            answer[1] = get_rank(count);
            return answer;
        }

        public int get_rank(int a){
            switch(a){
                case 6: return 1;
                case 5: return 2;
                case 4: return 3;
                case 3: return 4;
                case 2: return 5;
                default: return 6;
            }
        }

        // 1 25 31 33  0  0
        // 1  6 10 31 45 19
    }
}
