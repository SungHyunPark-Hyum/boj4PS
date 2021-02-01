package Sorting;

// O(dn)

// ex) n개의 d자리 정수들
// - 길이가 d인 문자열이며 각각의 문자들이 가질수 있는 값의 개수가 상수개 이다.
//   꼭, 정수일 필요는 없으며 길이가 d인 영문자도 가능하다
// - non-comparison sorting

import java.io.*;
import java.util.*;

public class Radix_sorting {
    public ArrayList<Queue<Integer>> arr;
    public int[] ret;
    public int[] tmp;
    public int index = 1;

    public Radix_sorting(int[] arr){
        this.ret = arr;
        this.getMax();
        this.arr = new ArrayList<>();
        for(int i=0; i<10; ++i)
            this.arr.add(new LinkedList<>());
    }

    public void radix_sort(){
        int loop = 0;
        int flag = 10;
        while(loop != index) {
            for (int i = 0; i < ret.length; ++i) {
                // (ret[i] / flag % 10) -> 현재 자리수에 해당
                arr.get((ret[i] / flag) % 10).add(ret[i]);
            }
            int start = 0;
            for(int i=0; i < 10; ++i){
                while(!arr.get(i).isEmpty()){
                    ret[start++] = arr.get(i).poll();
                }
            }
            flag *= 10;
            loop++;
        }
    }

    public void getMax(){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<ret.length; ++i){
            max = max > ret[i] ? max : ret[i];
        }
        while(max/10 != 0){
            max /= 10;
            index++;
        }
    }

    public void print() {
        for(int i=0; i<ret.length; ++i){
            System.out.print(ret[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {10, 769, 20, 5, 100, 152, 34, 97, 2541};
        Radix_sorting rs = new Radix_sorting(arr);
        System.out.println("before sorting");
        rs.print();
        rs.radix_sort();
        System.out.println("\nafter sorting");
        rs.print();
    }
}
