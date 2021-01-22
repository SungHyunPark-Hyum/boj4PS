import java.util.*;
import java.io.*;

// BOJ1427 소트인사이트 <정렬 단계>
public class boj1427 {
    public static void func(ArrayList<Integer> arr){
        Collections.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.size(); ++i)
            sb.append(arr.get(i));
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<str.length(); ++i){
            arr.add(str.charAt(i) - '0');
        }
        func(arr);
    }
}
