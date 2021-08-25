package a_Programmers.KAKAO_BLIND_RECRUITMENT_2018;

import java.io.*;
import java.util.*;

// Programmers [1차] 셔틀버스
public class Level3_ShuttleBus {
    public int start_time = 540;

    public String solution(int n, int t, int m, String[] timetable) {
        int ans = 0;
        int max = n * m;
        int people = timetable.length;
        int[] arr = new int[people];
        for(int i=0; i<people; ++i){
            arr[i] = parsing(timetable[i]);
        }
        Arrays.sort(arr);

        String answer;
        answer = reverseParsing(ans);
        return answer;
    }

    public String reverseParsing(int time){
        String hour = Integer.toString(time/60);
        String minute = Integer.toString(time%60);
        for(int i=0; i<2-hour.length(); ++i){
            hour = "0" + hour;
        }
        for(int i=0; i<2-minute.length(); ++i){
            minute = "0" + minute;
        }
        return hour+":"+minute;
    }

    public int parsing(String time){
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);

        return hour*60 + minute;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Level3_ShuttleBus lsb = new Level3_ShuttleBus();
        int n = 10;
        int t = 60;
        int m = 45;
        String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
        //n = 1; t = 1; m = 5; String[] timetable1 = {"08:00", "08:01", "08:02", "08:03"};
        System.out.println(lsb.solution(n, t, m, timetable));
    }
}
