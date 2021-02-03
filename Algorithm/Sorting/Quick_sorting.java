package Algorithm.Sorting;

// 최악 : O(n^2)
// 최선 : O(n log(n))

// divide and conquer
// use pivot
// use recursion

public class Quick_sorting {
    public static int[] arr = {5, 6, 2, 8, 7, 23, 4, 1, 10};

    public static void quick_sort(int[] arr, int l, int r){
        if(l < r){

            int q = partition(arr, l, r);
            quick_sort(arr, l, q-1);
            quick_sort(arr, q+1, r);
        }
    }

    // arr = {5, 6, 2, 8, 7, 23, 4, 1, 10};

    //         /    i  j            p /
    // arr = {5, 6, 2, 8, 1, 23, 4, 7, 10};

    //         /    i     j         p /
    // arr = {5, 6, 2, 8, 1, 23, 4, 7, 10};

    //         /       i      j     p /
    // arr = {5, 6, 2, 1, 8, 23, 4, 7, 10};

    //         /       i         j  p /
    // arr = {5, 6, 2, 1, 8, 23, 4, 7, 10};

    //         /          i      j  p /
    // arr = {5, 6, 2, 1, 4, 23, 8, 7, 10};

    //         /             p        /
    // arr = {5, 6, 2, 1, 4, 7, 23, 8, 10};

    // pivot = r
    public static int partition(int[] arr, int l, int r){
        int p = r;
        int pivot = arr[p];
        int i = l-1;
        int j = l;

        while(j<r){
            if(arr[j] > pivot){
                j++;
            }
            else{
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j++] = tmp;
            }
        }
        arr[p] = arr[i+1];
        arr[i+1] = pivot;
        p = i+1;

        return p;
    }

    public static void main(String[] args) {
        quick_sort(arr, 0, arr.length-1);
        System.out.println("sorted array : ");
        for(int i=0; i<arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }

}
