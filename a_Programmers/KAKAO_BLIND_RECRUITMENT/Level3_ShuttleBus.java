package a_Programmers.KAKAO_BLIND_RECRUITMENT;

import java.io.*;
import java.util.*;

// Programmers [1차] 셔틀버스
public class Level3_ShuttleBus {

    public static int parsing(String time){
        String hour = time.substring(0, 2);
        String minute = time.substring(3, 5);
        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        int len = timetable.length;
        int[] table = new int[len];
        for(int i=0; i<len; ++i){
            table[i] = parsing(timetable[i]);
        }

        Arrays.sort(table);

        int idx = 0;
        int last = table.length;
        int total = 0;
        int ret = -1;
        boolean flag = true;

        for(int i = 540; i< 540 + t * n; i+= t){
            int count = 0;
            while(count != m) {
                int waiter = table[idx];
                if (waiter <= i) {
                    count++; total++;
                    idx++;
                    if(total == t * m){
                        ret = table[idx-1];
                        flag = false;
                    }
                }
                else{
                    break;
                }
            }
            if(!flag)
                break;
        }

        String answer = "";
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parsing("09:00");
    }
}
