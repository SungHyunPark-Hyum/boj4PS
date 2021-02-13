package TheRest;

import java.io.*;
import java.util.*;

public class test4StringClass {

    public static void main(String[] args) throws IOException {
        String str = "01-abc123+한글1234";

        // StringTokenizer은 delim을 쪼개서도 나눠줌 ( | 없이도)
        StringTokenizer nums = new StringTokenizer(str, "+|-");
        StringTokenizer nums1 = new StringTokenizer(str, "+-");
        while(nums.hasMoreTokens()){
            System.out.print(nums.nextToken());
        }
        System.out.println();
        while(nums1.hasMoreTokens()){
            System.out.print(nums1.nextToken());
        }
        System.out.println();

        String restr1 = str.replaceAll("[^0-9]","");
        String restr2 = str.replaceAll("[0-9]","");
        String restr3 = str.replaceAll("[a-zA-Z]","");
        System.out.println(str + " ==> " + restr1);
        System.out.println(str + " ==> " + restr2);
        System.out.println(str + " ==> " + restr3);

        // .split은 정확히 regex에 맞는 문자열로 나눔
        // 중간에 비어있는 값도 출력
        // 맨 앞에 regex가 존재하는 경우 맨 앞에 빈값이 들어가게 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split("\\[|\\]|,");
        for(int i=0; i<ss.length; ++i){
            System.out.println(ss[i]);
        }
    }
}