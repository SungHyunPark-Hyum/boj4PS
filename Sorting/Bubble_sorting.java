package Sorting;

// O(n^2)

// 루프마다 swap
// 루프마다 가장 끝에 가장 큰 값이 저장됨

public class Bubble_sorting {
    public static int[] arr = {5, 6, 2, 8, 7, 23, 4, 1};

    public static void bubble_sort_ascend(int[] arr){
        int len = arr.length;
        for(int i=len-1; i>0; --i){
            for(int j=0; j<i; ++j){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            System.out.println("loop " + i);
            for(int j : arr)
                System.out.print(j + " ");
            System.out.println();
        }

        System.out.println("\n - result : ");
        for(int i : arr)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        bubble_sort_ascend(arr);
    }
}
