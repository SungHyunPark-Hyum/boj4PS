package BackTracking;

import java.io.*;
import java.util.*;

// BOJ 14002 가장 긴 증가하는 부분 수열 4 <동적 계획법과 역추적>
public class boj14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] ret = new int[N];
        int[] back = new int[N];
        int[] track = new int[N];

        ret[0] = arr[0];
        track[0] = 0; back[0] = -1;
        int idx = 0;
        for (int i = 1; i < N; ++i) {
            if (arr[i] > ret[idx]) {
                back[i] = track[idx];
                idx++;
                track[idx] = i;
                ret[idx] = arr[i];
            } else if(ret[idx] > arr[i]){
                int index = Arrays.binarySearch(ret, 0, idx, arr[i]);
                if (index < 0)
                    index = -index - 1;
                if (index == 0) {
                    back[i] = -1;
                } else {
                    back[i] = track[index-1];
                }
                track[index] = i;
                ret[index] = arr[i];
            }
        }
        System.out.println(idx + 1);

        idx = track[idx];
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> tmp = new ArrayList<>();
        while (true) {
            tmp.add(arr[idx]);
            if (back[idx] == -1)
                break;
            idx = back[idx];
        }
        for (int i = tmp.size() - 1; i >= 0; --i)
            sb.append(tmp.get(i)).append(" ");
        System.out.println(sb);
        br.close();
    }
}

