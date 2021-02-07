import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> arr1 = new ArrayList<>();
    public static ArrayList<Integer> arr2;

    public static void main(String[] args) {
        String str = "01-abc123-한글1234";
        String restr = str.replaceAll("[^0-9]","");
        System.out.println(str + " ==> " + restr);

    }
}