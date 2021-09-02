package a_Programmers;

import java.util.*;

class Level3_DiskController {
    public PriorityQueue<Disk> pq1;
    public PriorityQueue<Disk> pq2;

    public int solution(int[][] jobs) {
        int answer = 0;

        Comparator<Disk> cmp1 = new Comparator<Disk>(){
            @Override
            public int compare(Disk d1, Disk d2){
                if(d1.request == d2.request) return d1.take - d2.take;
                return d1.request - d2.request;
            }
        };

        Comparator<Disk> cmp2 = new Comparator<Disk>(){
            @Override
            public int compare(Disk d1, Disk d2){
                return d1.take - d2.take;
            }
        };

        pq1 = new PriorityQueue<Disk>(cmp1);
        pq2 = new PriorityQueue<Disk>(cmp2);
        for(int i=0; i<jobs.length; ++i){
            pq1.add(new Disk(jobs[i][0], jobs[i][1]));
        }

        int time_now = pq1.peek().request;
        pq2.add(pq1.poll());
        while(!pq2.isEmpty()){
            Disk tmp = pq2.poll();
            answer += (time_now + tmp.take - tmp.request);
            time_now += tmp.take;
            if(!pq1.isEmpty())
                while(pq1.peek().request <= time_now){
                    pq2.add(pq1.poll());
                    if(pq1.isEmpty()) break;
                }
            if(pq2.isEmpty() && !pq1.isEmpty()){
                pq2.add(pq1.poll());
                time_now = pq2.peek().request;
            }
        }

        return answer / jobs.length;
    }

    public class Disk{
        int request;
        int take;
        public Disk(int r, int t){
            this.request = r;
            this.take = t;
        }
    }
}
