package a_Programmers.WeeklyChallenge;

import java.util.*;

class Week6 {
    
    class Solution {
        public int[] solution(int[] weights, String[] head2head) {
            ArrayList<Boxer> arr = new ArrayList<Boxer>();
            for(int i=0; i<head2head.length; ++i){
                arr.add(new Boxer(head2head[i], weights[i], i, weights));
            }

            Comparator<Boxer> cmp = new Comparator<Boxer>(){
                @Override
                public int compare(Boxer e1, Boxer e2){
                    if(e1.win_rate == e2.win_rate){
                        if(e1.count_heavier == e2.count_heavier){
                            if(e2.weigth == e1.weigth){
                                return e1.idx- e2.idx;
                            }
                            return e2.weigth - e1.weigth;
                        }
                        return e2.count_heavier - e1.count_heavier;
                    }
                    return e2.win_rate - e1.win_rate > 0 ? 1 : -1;
                }
            };

            Collections.sort(arr, cmp);

            int[] answer = new int[arr.size()];
            for(int i=0; i<answer.length; ++i){
                answer[i] = arr.get(i).idx+1;
            }

            return answer;
        }

        public class Boxer{
            double win_rate;
            int count_heavier;
            int weigth;
            int idx;

            public Boxer(String h2h, int weigth, int index, int[] weights) {
                this.weigth = weigth;
                this.init(h2h, index, weights);
                this.idx = index;
            }

            public void init(String h2h, int index, int[] weights){
                int total = 0;
                int win = 0;
                for(int i=0; i<h2h.length(); ++i){
                    if(i == index)
                        continue;

                    char result = h2h.charAt(i);
                    if(result == 'N')
                        continue;
                    else {
                        total++;
                        if(result == 'W'){
                            win++;
                            if(this.weigth < weights[i]){
                                count_heavier++;
                            }
                        }
                    }
                }
                if(total == 0)
                    win_rate = 0;
                else {
                    win_rate = (double)win / (double)total;
                }
            }
        }
    }
}