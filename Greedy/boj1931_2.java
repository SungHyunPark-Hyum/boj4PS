import java.io.*;
import java.util.*;

// BOJ 1931 회의실 배정
public class boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<time> arr = new ArrayList<time>();
        PriorityQueue<time> pq = new PriorityQueue<>(new Comparator<time>() {
            @Override
            public int compare(time o1, time o2) {
                if(o1.end == o2.end)
                    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new time(start, end));
        }

        int endTime = pq.poll().end;

        int count = 1;
        while(!pq.isEmpty()){
            time tmp = pq.poll();
            if(tmp.start >= endTime){
                count++;
                endTime = tmp.end;
            }
        }

        System.out.println(count);
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
