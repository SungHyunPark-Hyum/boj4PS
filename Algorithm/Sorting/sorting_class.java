package Algorithm.Sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// 기본적으로 오름차순으로 정렬됨 (사전순(증가하는 방향으로) 생각하면 편할듯)

// Arrays.sort
// java.util.Arrays에 포함
// - 기본 타입 배열 정렬을 위해 (int[], byte[] , String[] ...)
// - Dual-Pivot QuickSort : 최악 O(n^2)

// Collections.sort
// - List Collection 정렬을 위해
// - TimSort(MergeSort를 최적화한) : O(n log(n))
// - Comparable 구현에 의해 정렬


// Comparator vs Comparable
// - Comparator
//   : compare 메소드
//   : 기본 정렬 기준 외에 다른 기준으로 정렬하고자할 때 사용
// - Comparable
//   : compareTo 메소드
//   : 기본 정렬 기준을 구현하는데 사용

public class sorting_class {
    public static ArrayList<Student> arr1;
    public static ArrayList<Student> arr2;

    public static void main(String[] args) throws IOException {
        // Arrays.sort & Collections.sort
        int[] data1 = {3, 6, 7, 10, 2, 1, 5, 8, 4, 9};
        Integer[] data2 = {3, 6, 7, 10, 2, 1, 5, 8, 4, 9};
        System.out.print("Original Array\n : ");
        for(int i : data1)
            System.out.print(i + " ");
        System.out.println();

        Arrays.sort(data1);
        Arrays.sort(data2, Collections.reverseOrder());
        System.out.print("- Array Sorted by Arrays.sort\n : ");
        for(int i : data1)
            System.out.print(i + " ");
        System.out.println();

        System.out.print("Array Sorted by Arrays.sort, Collections.reverseOrder()\n : ");
        for(int i : data2)
            System.out.print(i + " ");
        System.out.println("\n");


        String[] fruits1 = {"pineapple", "apple", "orange", "banana"};
        String[] fruits2 = {"pineapple", "apple", "orange", "banana"};
        System.out.print("Original Array\n : ");
        for(String i : fruits1)
            System.out.print(i + " ");
        System.out.println();

        Arrays.sort(fruits1);
        Arrays.sort(fruits2, Collections.reverseOrder());
        System.out.print("- Array Sorted by Arrays.sort\n : ");
        for(String i : fruits1)
            System.out.print(i + " ");
        System.out.println();

        System.out.print("Array Sorted by Arrays.sort, Collections.reverseOrder()\n : ");
        for(String i : fruits2)
            System.out.print(i + " ");
        System.out.println("\n");

        // Comparator vs Comparable
        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();

        addStudent();

        Comparator<Student> cmp = new Comparator<>(){
            @Override
            public int compare(Student s1, Student s2){
                // 앞에서 뒤를 때는 형식 -> 오름차순
                return s1.getId() - s2.getId();
            }
        };
        Collections.sort(arr1);
        Collections.sort(arr2, cmp);
        System.out.println("Array Sorted by Comparable (name)");
        print(arr1);
        System.out.println("Array Sorted by Comparator (id)");
        print(arr2);
    }

    public static class Student implements Comparable<Student>{
        public int id;
        public String name;
        public char score;

        public Student(int id, String name, char score){
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public int getId(){
            return this.id;
        }

        public String getName(){
            return this.name;
        }

        public char getScore(){
            return this.score;
        }

        @Override
        public int compareTo(Student student){
            return name.compareTo(student.getName());
        }
    }

    public static void addStudent(){
        arr1.add(new Student(100, "psh", 'A'));
        arr1.add(new Student(106, "ksr", 'F'));
        arr1.add(new Student(101, "pjs", 'B'));
        arr1.add(new Student(102, "kkm", 'C'));
        arr1.add(new Student(103, "abc", 'B'));
        arr1.add(new Student(105, "zyu", 'A'));
        arr1.add(new Student(104, "tty", 'B'));
        arr2.add(new Student(100, "psh", 'A'));
        arr2.add(new Student(106, "ksr", 'F'));
        arr2.add(new Student(101, "pjs", 'B'));
        arr2.add(new Student(102, "kkm", 'C'));
        arr2.add(new Student(103, "abc", 'B'));
        arr2.add(new Student(105, "zyu", 'A'));
        arr2.add(new Student(104, "tty", 'B'));
    }

    public static void print(ArrayList<Student> arr){
        for(int i=0; i<arr.size(); ++i){
            System.out.print(arr.get(i).getId() + " ");
            System.out.print(arr.get(i).getName() + " ");
            System.out.println(arr.get(i).getScore() + " ");
        }
        System.out.println();
    }
}
