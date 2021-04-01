package a_Programmers.KAKAO_BLIND_RECRUITMENT;
import java.util.*;

public class Level3_TrafficOfChuseok {
    public int solution(String[] lines) {
        ArrayList<Log> logs = getTime(lines);
        int answer = 0;
        for(int i=0; i<logs.size(); ++i){
            int count1 = 0, count2 = 0;
            int startTemp = logs.get(i).startTime;
            int endTemp = logs.get(i).endTime;
            int startFlag = startTemp + 999;
            int endFlag = endTemp + 999;
            for(int j=0; j<logs.size(); ++j){
                int st = logs.get(j).startTime;
                int et = logs.get(j).endTime;
                if(st <= startFlag && et >= startTemp)
                    count1++;
                if(st <= endFlag && et >= endTemp)
                    count2++;
            }
            answer = Math.max(answer, Math.max(count1, count2));
        }
        return answer;
    }

    public ArrayList<Log> getTime(String[] lines){
        ArrayList<Log> logs = new ArrayList<>();
        for(int i=0; i<lines.length; ++i){
            StringTokenizer st = new StringTokenizer(lines[i]);
            st.nextToken();
            String time = st.nextToken();
            String over = st.nextToken();
            String[] times = time.split(":");
            int hour = Integer.parseInt(times[0]);
            int minute = Integer.parseInt(times[1]);
            double second = Double.parseDouble(times[2]);
            int endTime =
                    hour * 3600 * 1000
                    + minute * 60 * 1000
                    + (int)(second * 1000);

            double minus = Double.parseDouble(over.substring(0, over.length()-1));
            int startTime = endTime - (int)(minus*1000) + 1;
            logs.add(new Log(startTime, endTime));
        }

        return logs;
    }

    public static void main(String[] args) {
        Level3_TrafficOfChuseok aa = new Level3_TrafficOfChuseok();
        String[] input = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(aa.solution(input));
    }

    public class Log{
        int startTime, endTime;
        public Log(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
