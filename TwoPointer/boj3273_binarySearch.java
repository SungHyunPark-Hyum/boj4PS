import java.io.*;
import java.util.*;

// BOJ 3273 두 수의 합 <투 포인터>
public class boj3273_binarySearch {
    public static int n;
    public static ArrayList<Node> arr;

    public static int lowerBound(int target){
        int l = 0;
        int r = n;
        while(l<r){
            int mid = (l+r)/2;
            if(arr.get(mid).num >= target){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }

    public static int binarySearch(int target){
        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr.get(mid).num == target){
                return mid;
            }
            else if(arr.get(mid).num > target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        for(int i=0; i<n; ++i){
            int a = Integer.parseInt(st.nextToken());
            arr.add(new Node(a, i));
        }

        Collections.sort(arr, new Comparator<Node>(){
            @Override
            public int compare(Node e1, Node e2){
                return e1.num - e2.num;
            }
        });

        int target = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0; i<n; ++i){
            int tmp = target - arr.get(i).num;
            if(tmp < 0)
                break;

            int idx = binarySearch(tmp);
            if(idx == -1) continue;
            if(arr.get(idx).idx > arr.get(i).idx)
                ans++;
        }
        System.out.println(ans);
        br.close();
    }

    public static class Node{
        public int num, idx;
        public Node(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }
}
