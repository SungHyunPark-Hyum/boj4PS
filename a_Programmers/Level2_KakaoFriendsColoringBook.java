package a_Programmers;

public class Level2_KakaoFriendsColoringBook {
    class Solution {
        public int[] dx = {0, -1, 1, 0};
        public int[] dy = {-1, 0, 0, 1};
        public boolean[][] visit;
        public int[][] map;
        public int m, n;

        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            visit = new boolean[m][n];
            this.map = picture;
            this.m = m;
            this.n = n;

            for(int i=0; i<m; ++i){
                for(int j=0; j<n; ++j){
                    if(!visit[i][j] && map[i][j] != 0){
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(i, j));
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        public int dfs(int x, int y){
            visit[x][y] = true;

            int count = 1;
            for(int i=0; i<4; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(check(nx, ny, map[x][y])){
                    count += dfs(nx, ny);
                }
            }
            return count;
        }

        public boolean check(int x, int y, int a){
            if(x < 0 || y < 0 || x >=m || y >= n) return false;
            if(visit[x][y]) return false;
            if(map[x][y] != a) return false;
            return true;
        }
    }

// 1 1 1 0
// 1 2 2 0
// 1 0 0 1
// 0 0 0 1
// 0 0 0 3
// 0 0 0 3
}
