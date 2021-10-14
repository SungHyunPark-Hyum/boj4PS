package a_Programmers.WeeklyChallenge;

public class Week8 {
    class Solution {
        public int solution(int[][] sizes) {

            int row = sizes[0][0], column = sizes[0][1];
            int answer = row * column;

            for(int i=1; i<sizes.length; ++i){
                int tmp1 = Math.max(row, sizes[i][0]);
                int tmp2 = Math.max(column, sizes[i][1]);
                int tmp3 = tmp1 * tmp2;

                int tmp4 = Math.max(row, sizes[i][1]);
                int tmp5 = Math.max(column, sizes[i][0]);
                int tmp6 = tmp4 * tmp5;

                int tmp = Math.min(tmp3, tmp6);

                answer = tmp;
                if(tmp == tmp3){
                    row = tmp1; column = tmp2;
                }
                else{
                    row = tmp4; column = tmp5;
                }
            }

            return answer;
        }
        // 60 50
        // 70 60
        // 80 30
    }
}
