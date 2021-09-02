package a_Programmers;

import java.util.*;

class Level2_SpinningMatrixEdge {
    public int[][] puzzle;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        puzzle = new int[rows+1][columns+1];
        for(int i=1; i<=rows; ++i){
            for(int j=1; j<=columns; ++j){
                puzzle[i][j] = (i-1) * columns + j;
            }
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int k=0; k<queries.length; ++k){
            arr.add(spin(queries[k]));
        }

        answer = arr.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public int spin(int[] query){
        int x1 = query[0]; int y1 = query[1];
        int x2 = query[2]; int y2 = query[3];

        int memory = puzzle[x1][y1];
        int min = memory;

        for(int i = x1; i <= x2-1; ++i){
            puzzle[i][y1] = puzzle[i+1][y1];
            min = Math.min(puzzle[i][y1], min);
        }

        for(int i = y1; i<= y2-1; ++i){
            puzzle[x2][i] = puzzle[x2][i+1];
            min = Math.min(puzzle[x2][i], min);
        }

        for(int i = x2; i>= x1+1; --i){
            puzzle[i][y2] = puzzle[i-1][y2];
            min = Math.min(puzzle[i][y2], min);
        }

        for(int i = y2; i>= y1+1; --i){
            puzzle[x1][i] = puzzle[x1][i-1];
            min = Math.min(puzzle[x1][i], min);
        }

        puzzle[x1][y1+1] = memory;

        return min;
    }
}