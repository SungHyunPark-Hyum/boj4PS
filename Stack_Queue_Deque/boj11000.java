package Stack_Queue_Deque;

import java.util.*;
import java.io.*;

// BOJ 11000 강의실 배정
public class boj11000 {
    public static PriorityQueue<time> pq;
    public static ArrayList<time> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new ArrayList<time>();
        pq = new PriorityQueue<time>(new Comparator<time>(){
            public int compare(time t1, time t2){
                if(t1.end == t2.end)
                    return t1.start - t2.start;
                return t1.end - t2.end;
            }
        });

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr.add(new time(s, t));
        }

        Collections.sort(arr, new Comparator<time>() {
            @Override
            public int compare(time o1, time o2) {
                if(o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        for(time tmp : arr){
            if(!pq.isEmpty()){
                time top = pq.peek();
                if(tmp.start >= top.end){
                    pq.poll();
                }
            }
            pq.add(tmp);
        }

        System.out.println(pq.size());
    }

    public static class time{
        int start;
        int end;

        public time(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
}