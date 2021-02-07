package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ 2580 스도쿠 <백트래킹 단계>
public class boj2580 {
    public static int depth = 0;
    public static int[][] map = new int[9][9];
    public static ArrayList<xy> arr = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static ArrayList<Integer> getAvail(int x, int y){
        boolean[] avail = new boolean[9];

        for(int i=0; i<9; ++i){
            if(map[x][i] != 0){
                avail[map[x][i]-1] = true;
            }
            if(map[i][y] != 0){
                avail[map[i][y]-1] = true;
            }
        }

        int xx = x - x%3;
        int yy = y - y%3;
        for(int i = xx; i<xx+3; ++i){
            for(int j = yy; j<yy+3; ++j){
                if(map[i][j] != 0) {
                    avail[map[i][j] - 1] = true;
                }
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i=0; i<9; ++i){
            if(!avail[i])
                ret.add(i+1);
        }
        return ret;
    }

    public static void dfs(int a){
        if(a == depth){
            print();
            System.out.println(sb);
            System.exit(0);
        }

        xy XY = arr.get(a);
        int x = XY.getX();
        int y = XY.getY();
        ArrayList<Integer> now = getAvail(x, y);
        for(int i=0; i<now.size(); ++i){
            map[x][y] = now.get(i);
            dfs(a+1);
            map[x][y] = 0;
        }
    }

    public static void print(){
        for(int i=0; i<9; ++i){
            for(int j=0; j<9; ++j){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<9; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; ++j){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a == 0) {
                    arr.add(new xy(i, j));
                    depth++;
                }
            }
        }
        dfs(0);
    }

    public static class xy{
        public int x, y;
        public xy(int x, int y){
            this.x = x; this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }
    }
}
