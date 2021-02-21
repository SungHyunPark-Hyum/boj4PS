import BruteForce.boj7568;

import java.io.*;
import java.util.*;

public class tmax_2 {
    public static class Node {
        public int i, grade, rank;
        public Node(int i, int grade) {
            this.i = i;
            this.grade = grade;
            this.rank = 1;
        }

        public void update(int a){
            this.rank = a;
        }
    }

    public static int upperBound(ArrayList<Node> arr, int target){
        int left = 0;
        int right = arr.size();

        while(left<right){
            int mid = (left+right)/2;
            if(arr.get(mid).grade <= target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    public static int[] solution(int[] grade) {
        int[] answer = new int[grade.length];
        ArrayList<Node> arr = new ArrayList<>();
        for(int i=0; i<grade.length; ++i){
            arr.add(new Node(i, grade[i]));
        }

        Comparator<Node> cmp1 = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.grade - o2.grade;
            }
        };
        Collections.sort(arr, cmp1);
        for(int i=0; i< grade.length; ++i){
            System.out.println("i : " + arr.get(i).i + " / grade = " + arr.get(i).grade);
        }

        for(int i=0; i<grade.length; ++i){
            int idx = upperBound(arr, arr.get(i).grade);
            System.out.println("upper bound of " + arr.get(i).grade + " is " + idx);
            System.out.println("this num's index is " + arr.get(i).i);
            arr.get(i).update(grade.length - idx);
        }

        for(int i=0; i<grade.length; ++i){
            Node e = arr.get(i);
            answer[e.i] = e.rank + 1;
        }
        for(int i=0; i<grade.length; ++i){
            System.out.print(answer[i] + " ");
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{2, 2, 1};
        solution(arr);

        System.out.println();
        System.out.println();
        int[] tmp = new int[]{15, 13, 16, 5, 1, 13};
        solution(tmp);

        int[] arr2 = new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5, 6, 7, 8, 8};
        System.out.println();
        System.out.println();
        solution(arr2);
    }
}
