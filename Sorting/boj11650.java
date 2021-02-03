import java.util.*;
import java.io.*;

// BOJ11650 좌표 정렬하기 <정렬 단계>
public class boj11650 {
    public static class Node {
        int x; int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        ArrayList<Node> arr = new ArrayList<>();
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Node(x, y));
        }

        Comparator<Node> cmp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o2.x == o1.x)
                    return o1.y - o2.y;
                return o1.x - o2.x;
            }
        };
        Collections.sort(arr, cmp);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; ++i){
            sb.append(arr.get(i).x).append(" ").append(arr.get(i).y).append("\n");
        }
        System.out.println(sb.toString());
    }
}
