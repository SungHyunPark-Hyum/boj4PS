import java.util.Scanner;

public class Main {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int spell[][] = new int[num][2]; //몸무게, 키
        int rank[] =new int[num]; //순위

        for(int i=0;i<num;i++) {
            rank[i] = 1;
            spell[i][0] = sc.nextInt(); //몸무게
            spell[i][1] = sc.nextInt(); //키
        }

        for(int i=0; i<num;i++) {
            for(int j=0; j<num;j++) {
                if(spell[i][0]>spell[j][0] && spell[i][1]>spell[j][1]) {
                    rank[j]++;
                }
            }
        }
        for(int i=0; i<num;i++) {
            System.out.print(rank[i]+" ");
        }
    }
}