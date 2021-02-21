import java.io.*;
import java.util.*;

public class tmax_1 {

    public static int solution(int a, int b, int budget) {
        int answer = 0;

        int aa = Math.max(a, b);
        int bb = Math.min(a, b);
        int num = budget / bb;
        while(num >= 0){
            int tmp = budget - bb * num;
            if(tmp % aa == 0){
                answer++;
            }
            num--;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 1, 100));
    }
}
