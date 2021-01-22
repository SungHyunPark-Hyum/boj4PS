package Sorting;

// O(nlog(n))

// divide and conquer
// use recursion(재귀)

public class Merge_sorting {
    public static int[] arr = {5, 6, 2, 8, 7, 23, 4, 1, 10};
    public static int[] sorted_arr = new int[9];

    public static void merge_sort(int[] arr, int l, int r) {
        if(l < r) {
            int mid = (l+r)/2;
            merge_sort(arr, 0, mid);
            merge_sort(arr, mid+1, r);
            System.out.println("l = " + l + " / mid = " + mid + " / r = " + r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r){
        int[] tmp = new int[arr.length];
        int i = l;
        int j = mid+1;
        int k = l;

        while(i < mid+1 && j < r+1){
            if(arr[i] < arr[j]){
                tmp[k++] = arr[i++];
            }
            else{
                tmp[k++] = arr[j++];
            }
        }

        while(i<=mid){
            tmp[k++] = arr[i++];
        }
        while(j<=r){
            tmp[k++] = arr[j++];
        }

        for(int t=l; t<=r; ++t){
            arr[t] = tmp[t];
        }
    }

    public static void main(String[] args) {
        merge_sort(arr, 0, arr.length-1);
        System.out.println("sorted array : ");
        for(int i=0; i<arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }
}
