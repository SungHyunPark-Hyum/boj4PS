package BackTracking;

import java.io.*;
import java.util.*;

// BOJ 14889 스타트와 링크 <백트래킹 단계>
public class boj14889 {
    public static int N;
    public static int[][] map;
    public static boolean[] visit;
    public static int min = Integer.MAX_VALUE;

    public static void calcAns(){
        int team1 = 0;
        int team2 = 0;
        for(int i=0; i<N-1; ++i){
            for(int j=i+1; j<N; ++j){
                if(visit[i] == true && visit[j] == true) {
                    team1 += map[i][j];
                    team1 += map[j][i];
                }
                else if(visit[i] == false && visit[j] == false) {
                    team2 += map[i][j];
                    team2 += map[j][i];
                }
            }
        }

        int result = Math.abs(team1 - team2);
        min = Math.min(min, result);
    }

    public static void dfs(int a, int count){
        if(count == N/2){
            calcAns();
            return;
        }

        for(int i=a; i<N; ++i){
            if(!visit[i]){
                visit[i] = true;
                dfs(i+1, count+1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; ++j){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
            }
        }

        visit = new boolean[N];
        visit[0] = true;
        dfs(1, 1);
        System.out.println(min);
    }
}

