package BinarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// BOJ 2805 나무 자르기 <이분 탐색>
public class boj2805_TimeOut {
    public static long N, M;
    public static ArrayList<Long> trees;

    public static long solution(){
        long flag = trees.get(0);
        if(trees.size() == 1){
            return flag - M;
        }
        flag = trees.get(1);
        int flag_num = 1;
        long tmp = 0;

        while(true){
            for(int i=0; i<flag_num; ++i){
                tmp += trees.get(i) - flag;
            }
            if(tmp >= M)
                break;

            tmp = 0;
            flag_num++;
            flag = trees.get(flag_num);
        }

        long r = trees.get(flag_num-1);
        long l = trees.get(flag_num);

        long ans = 0;
        while(l <= r){
            tmp = 0;
            long mid = (l + r) / 2;
            for(int i=0; i<flag_num; ++i){
                tmp += trees.get(i) - mid;
            }

            if(tmp >= M){
                ans = Math.max(ans, mid);
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        trees = new ArrayList<Long>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) {
            trees.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(trees, Collections.reverseOrder());

        System.out.println(solution());
    }
}
