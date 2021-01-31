package Sorting;

// 최악 : O(n^2)
// 최선 : O(n log(n))

// divide and conquer
// use pivot
// use recursion

public class Quick_sorting_medianOfthree {
    public static int[] arr = {5, 6, 2, 8, 7, 23, 4, 1, 10};
    //                         0, 1, 2, 3, 4 , 5, 6, 7,  8

    public static void sortThree(int[] arr, int front, int mid, int rear){
        int first = Math.min(Math.min(arr[front], arr[mid]), arr[rear]);
        int third = Math.max(Math.max(arr[front], arr[mid]), arr[rear]);
        int second = arr[front] + arr[mid] + arr[rear] - first - third;
        arr[front] = first;
        arr[mid] = second;
        arr[rear] = third;
    }

    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(){
        for(int i=0; i<arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void quick_sort(int[] arr, int l, int r){
        if(r-l > 2) {
            int mid = (l + r) / 2;
            sortThree(arr, l, mid, r);
            swap(mid, r - 1);
            System.out.println(l + " " + mid + " " + r);
            System.out.println("after sortThree");
            print();
        }
        if(l < r){

            int q = partition(arr, l+1, r-1);
            System.out.println("after partition");
            print();
            System.out.println();
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
        print();
        System.out.println();
        quick_sort(arr, 0, arr.length-1);
        System.out.println("sorted array : ");
        for(int i=0; i<arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }

}
