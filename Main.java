import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> arr1 = new ArrayList<>();
    public static ArrayList<Integer> arr2;

    public static void main(String[] args) {
        arr1.add(3);
        arr1.add(2);
        arr2 = arr1;
        Collections.sort(arr2);
        System.out.println(arr1.get(0));
        System.out.println(arr2.get(0));

    }
}