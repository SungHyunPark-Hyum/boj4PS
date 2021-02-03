package Algorithm.Sorting;

import java.io.*;

public class PriorityQueue {
    public int[] arr;
    public int size;

    public PriorityQueue(int n){
        arr = new int[n];
        size = 0;
    }

    public void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void heapify(int root){
        int leftChild = root * 2;
        int rightChild = root * 2 + 1;
        int swapNode = -1;

        if(leftChild > size) {
            return;
        }
        if(leftChild == size && rightChild > size) {
            swapNode = leftChild;
        }
        if(rightChild <= size){
            swapNode = arr[leftChild] > arr[rightChild] ? leftChild : rightChild;
        }

        if(arr[root] < arr[swapNode]){
            swap(root, swapNode);
            heapify(swapNode);
        }
    }

    public int extract(){
        System.out.println("extract");
        if(size == 0){
            System.out.println("PriorityQueue가 비어있습니다.");
            return -1;
        }
        int ret = arr[1];
        swap(size--, 1);
        heapify(1);
        return ret;
    }

    public void insert(int a){
        size++;
        arr[size] = a;
        for(int i=size/2; i>=1; --i){
            heapify(i);
        }
    }

    public void print(){
        for(int i=1; i<=size; ++i){
            System.out.println(arr[i] + " (" + i + ")");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue pq = new PriorityQueue(100);
        while(true){
            System.out.println("입력하세요 ( 1-> insert, 2-> extract, 3->print, 4->exit )");
            int flag = Integer.parseInt(br.readLine());
            if(flag == 1){
                System.out.println("insert할 숫자를 입력하세요 : ");
                int num = Integer.parseInt(br.readLine());
                pq.insert(num);
            }
            else if(flag == 2){
                int ret = pq.extract();
                System.out.println("extrct : " + ret);
            }
            else if(flag == 3){
                pq.print();
            }
            else{
                break;
            }
            System.out.println();
        }
        br.close();
    }
}
