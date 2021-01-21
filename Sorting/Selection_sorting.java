package Sorting;

// O(n^2)

// 각 루프마다
// - 최대 원소를 찾는다.
// - 최대 원소와 맨 오른쪽 원소를 교환한다.
// - 맨 오른쪽 원소를 루프에서 제거한다.

public class Selection_sorting {
    public static int[] arr = {5, 6, 2, 8, 7, 23, 4, 1};

    public static void selection_sort_ascend(int[] arr) {
        int len = arr.length;
        int min, tmp;
        for(int i=0; i<len-1; ++i){
            min = i;
            for(int j=i+1; j<len; ++j){
                min = arr[min] < arr[j] ? min : j;
            }
            //swap min <-> i
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;

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
        selection_sort_ascend(arr);
    }
}
