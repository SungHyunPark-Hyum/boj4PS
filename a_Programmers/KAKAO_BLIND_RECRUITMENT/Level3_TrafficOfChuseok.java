package a_Programmers.KAKAO_BLIND_RECRUITMENT;
import java.util.*;

public class Level3_TrafficOfChuseok {

    public static void main(String[] args) {
        Level3_TrafficOfChuseok aa = new Level3_TrafficOfChuseok();
        String[] input = {"2016-09-15 00:00:58.998 1.5s"};
        System.out.println(aa.solution(input));
    }

    public void calcTime(String time, String over){
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        double second = Double.parseDouble(times[2]);
        over = over.substring(0, over.length()-1);
        double add = Double.parseDouble(over);
        //checkTime(hour, minute, second, add);
    }

    public int solution(String[] lines) {
        for(int i=0; i<lines.length; ++i){
            StringTokenizer st = new StringTokenizer(lines[i]);
            st.nextToken();
            String time = st.nextToken();
            String over = st.nextToken();
            calcTime(time, over);
        }
        return 0;
    }
}
