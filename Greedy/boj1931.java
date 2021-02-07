package Greedy;

import java.io.*;
import java.util.*;

// BOJ 1931 회의실 배정 <그리디 알고리즘>
public class boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<meeting> meetings = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings.add(new meeting(s, e));
        }

        Comparator<meeting> cmp = new Comparator<meeting>(){
            @Override
            public int compare(meeting m1, meeting m2){
                if(m1.end == m2.end) return m1.start-m2.end;
                return m1.end - m2.end;
            }
        };
        Collections.sort(meetings, cmp);

        int ans = 0;
        int start = 0;
        int end = 0;
        for(int i=0; i<meetings.size(); ++i){
            meeting m = meetings.get(i);
            if(m.start >= end){
                end = m.end;
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static class meeting {
        public int start, end;

        public meeting(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
}
