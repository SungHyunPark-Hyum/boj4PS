import java.util.*;
import java.io.*;

// BOJ1018 통계학 <정렬 단계>
public class boj2108_sorting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr1 = new ArrayList<>();
        int[] arr2 = new int[16003];
        ArrayList<Integer> counting = new ArrayList<>();
        int max_count = 1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<N; ++i){
            int n = Integer.parseInt(br.readLine());
            arr1.add(n);
            arr2[n+4000]++;
            max_count = max_count > arr2[n+4000] ? max_count : arr2[n+4000];
            sum += n;
        }
        sb.append((int)Math.round((double) sum/N)).append("\n");

        Collections.sort(arr1);
        sb.append(arr1.get(N/2)).append("\n");

        for(int i=0; i<=8000; ++i){
            if(arr2[i] == max_count) {
                counting.add(i - 4000);
            }
        }
        if(counting.size() == 1)
            sb.append(counting.get(0)).append("\n");
        else{
            Collections.sort(counting);
            sb.append(counting.get(1)).append("\n");
        }

        sb.append(arr1.get(N-1) - arr1.get(0));

        System.out.println(sb.toString());
    }
}
