
import java.util.*;

public class tmax_3 {
    public static long solution(int n) {
        long answer = 1;
        int loop = n;

        while (loop > 1) {
            int[] arr = new int[loop];
            Arrays.fill(arr, n / loop);
            for (int i = 0; i < n%loop; ++i) {
                arr[i]++;
            }
            long tmp = 1;
            for(int i=0; i<loop; ++i){
                tmp *= arr[i];
            }

            answer = Math.max(answer, tmp);

            loop--;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(100));
    }
}
