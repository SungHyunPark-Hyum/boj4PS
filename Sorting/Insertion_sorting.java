package Sorting;

// O(n^2)

// k-1번째 까지 정렬된 배열이라고 가정
// 앞에 정렬된 배열 중 k가 삽입될 위치를 찾아 삽입
// 삽입과정에서 shift를 해주어야 하는데 뒤에서부터 searching하면서 하는 것이 효율적
// (뒤에서 보면 방문과 shift를 함께 진행할 수 있기 때문에)

public class Insertion_sorting {
    public static int[] arr = {5, 6, 2, 8, 7, 23, 4, 1};

    public static void insertion_sort_ascend(int[] arr) {
        int len = arr.length;

        for(int i=1; i<len; ++i){
            for(int j=i; j>0; --j){
                if(arr[j-1] > arr[j]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
                else
                    continue;
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
        insertion_sort_ascend(arr);
    }
}
