import java.util.*;
import java.io.*;

// BOJ2751 수 정렬하기2 <정렬하기>
public class boj2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int loop = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(loop != n){
            int tmp = Integer.parseInt(br.readLine());
            arr.add(tmp);
            loop++;
        }
        Collections.sort(arr);
        loop = 0;
        StringBuilder sb = new StringBuilder();
        while(loop != n){
            sb.append(arr.get(loop) + "\n");
            loop++;
        }
        System.out.println(sb.toString());
    }
}
