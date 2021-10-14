package a_Programmers;

import java.util.*;

public class Level2_MenuRenewal1 {

    class Solution {
        public Queue<String> ans;
        public ArrayList<String> ansDP;
        public HashMap<String, Integer> hm;
        public int max;

        public String[] solution(String[] orders, int[] course) {
            this. ansDP = new ArrayList<String>();
            for(int j=0; j<course.length; ++j){
                this.init();
                // System.out.println("course of " + course[j]);
                for(int i=0; i<orders.length; ++i){
                    // System.out.println("order of " + orders[i]);
                    char[] tmp = orders[i].toCharArray();
                    Arrays.sort(tmp);
                    orders[i] = new String(tmp);
                    comb(0, 0, course[j], orders[i], "");
                }
                while(!ans.isEmpty()){
                    ansDP.add(ans.poll());
                }
            }

            Collections.sort(ansDP);

            String[] answer = new String[ansDP.size()];
            for(int i=0; i<answer.length; ++i){
                answer[i] = ansDP.get(i);
            }
            return answer;
        }

        public void init(){
            this.ans = new LinkedList<String>();
            this.hm = new HashMap<String, Integer>();
            this.max = Integer.MIN_VALUE;
        }

        public void comb(int index, int depth, int course, String str, String dp){
            if(depth == course){
                // System.out.println(dp);
                if(hm.containsKey(dp)){
                    hm.replace(dp, hm.get(dp)+1);
                }
                else{
                    hm.put(dp, 1);
                }

                int count = hm.get(dp);
                if(count >= 2){
                    if(max == count){
                        ans.add(dp);
                    }
                    else if(max < count){
                        this.max = count;
                        ans = new LinkedList<String>();
                        ans.add(dp);
                    }
                }

                return;
            }

            for(int i=index; i<str.length(); ++i){
                String tmp = dp + str.charAt(i);
                comb(i+1, depth+1, course, str, tmp);
            }
        }
    }
}
