package Sorting;

// O(n log(n))

// Sort in place - 추가 배열 불필요
// merge_sort의 경우 추가배열 필요
// 이진 힙(binary heap) 자료구조를 사용

import java.util.ArrayList;

public class Heap_sorting {
    public static int[] arr = {5, 6, 2, 8, 7, 23, 4, 1, 10};
    public static int[] max_heap = new int[arr.length];
    //            5(0)
    //      6(1)       2(2)
    //   8(3)  7(4)  23(5) 4(6)
    // 1(7) 10(8)

    public static void addNode(int a, int i){
        max_heap[i] = a;
    }

    public static void print_sorted(int[] arr){
        for(int i=0; i<arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void heap_sort(int[] arr) {
        System.out.println("before sorting");
        print_sorted(arr);
        System.out.println();

        build_max_heap(arr);
        System.out.println("after build_max_heap");
        print_sorted(arr);
        System.out.println();

        int size = arr.length;
        while(size != 2){
            swap(0, size-1);
            size--;
            max_heapify(0, size);
        }
        System.out.println("after whole sorting");
        print_sorted(arr);
    }

    public static void build_max_heap(int[] arr){
        for(int i=arr.length/2; i>=0; --i){
            max_heapify(i, arr.length);
        }
    }

    public static void max_heapify(int i, int size){
        int parent = i;
        int leftChild = 2*parent + 1;
        int rightChild = 2*parent + 2;
        if(rightChild >= size)
            return;

        int swapNode = arr[leftChild] > arr[rightChild] ? leftChild : rightChild;
        if(arr[parent] < arr[swapNode]){
            swap(parent, swapNode);
        }
        else{
            return;
        }

        max_heapify(swapNode, size);
    }

    public static void swap(int i, int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        heap_sort(arr);
    }
}
