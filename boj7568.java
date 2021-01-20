import java.util.*;
import java.io.*;

//BOJ_7568 덩치 <브루트포스>
public class boj7568 {
    public static class Node {
        public int i, weight, height, rank;
        public Node(int i, int weight, int height) {
            this.i = i;
            this.weight = weight;
            this.height = height;
            this.rank = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Node(i, x, y));
        }

        for(int i=0; i<N; ++i){
            int height_now = arr.get(i).height;
            int weight_now = arr.get(i).weight;
            for(int j=0; j<N; ++j){
                if(i==j)
                    continue;
                if(height_now > arr.get(j).height
                        && weight_now > arr.get(j).weight)
                    arr.get(j).rank++;
            }
        }
        sb = new StringBuilder();
        for(int i=0; i<N; ++i){
            sb.append(arr.get(i).rank + " ");
        }
        System.out.println(sb.toString());
    }
}
