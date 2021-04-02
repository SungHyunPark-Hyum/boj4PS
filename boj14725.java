import java.io.*;
import java.util.*;

// BOJ 14725 개미굴
public class boj14725 {
    public static StringBuilder sb = new StringBuilder();
    public static String af = "--";

    public static void dfs(Node root, int count){
        int cc = count;
        if(!root.data.equals("")) {
            while(cc-- > 0){
                sb.append(af);
            }
            sb.append(root.data).append("\n");
        }

        if(root.child.size() == 0) {
            return;
        }

        Collections.sort(root.child, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data.compareTo(o2.data);
            }
        });
        for(Node e : root.child){
            dfs(e, count+1);
        }
    }

    public static void setNodes(Node root, String tmp) {
        String[] data = tmp.split(" ");
        int len = data.length;

        setTree(root, data, 0, 0, len);
    }

    public static void setTree(Node root, String[] data, int i, int count, int len) {
        if (count == len)
            return;

        if (!root.sChild.contains(data[i])) {
            root.sChild.add(data[i]);
            root.child.add(new Node(data[i]));
        }
        root = root.child.get(root.sChild.indexOf(data[i]));
        setTree(root, data, i + 1, count + 1, len);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node root = new Node("");
        String[] tmp = new String[T];
        for (int i = 0; i < T; ++i) {
            tmp[i] = br.readLine();
            tmp[i] = tmp[i].substring(2, tmp[i].length());
        }
        for (int i = 0; i < T; ++i){
            setNodes(root, tmp[i]);
        }
        dfs(root, -1);
        System.out.print(sb);
        br.close();
    }

    public static class Node {
        String data;
        ArrayList<Node> child = null;
        ArrayList<String> sChild = null;

        public Node(String data) {
            this.data = data;
            this.child = new ArrayList<>();
            this.sChild = new ArrayList<>();
        }
    }
}
