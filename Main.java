import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] counting = new int[8001];

        // 합계
        int sum = 0;
        for(int i = 0;i<N;i++) {
            int n = Integer.parseInt(bf.readLine());
            sum+=n;
            counting[n+4000]++;
        }
        // 중앙값
        int mid =-1;
        int times = 0;
        while(times<(N+1)/2){
            mid++;
            times+=counting[mid];
        }
        mid = mid-4000;


        // 최대, 최소

        int minloc = 0;
        int maxloc = 8000;
        while(counting[minloc]==0) {
            minloc++;
        }
        while(counting[maxloc]==0) {
            maxloc--;
        }
        // 최빈값
        int maxcount = 0; //가장 자주 나타난 수의 빈도을 저장하는 변수
        int maxcountnum = 0; // 가장 많이 나타난 수
        int num = 0; // 가장 큰 빈도의 빈도의 값를 저장하는 변수
        int fre2 =-1 ; // 최빈값이 2개 이상이면 두번째로 작은 값 저장, 1개면 -1 저장
        for(int i = 0;i<=8000;i++) {
            if(maxcount<counting[i]) {
                maxcount = counting[i];
                maxcountnum = i-4000;
                num = 1;
                fre2 = -1;
                System.out.println("new : " + (i-4000));
            }else if(maxcount==counting[i]) {
                num ++;
                if (num ==2) {
                    System.out.println(maxcount);
                    fre2 = i-4000;
                    System.out.println("fre2 : " + fre2);
                }
            }else {
            }
        }
        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString((int) Math.round((double)sum/(double)N)));
        bw.newLine();
        bw.write(Integer.toString(mid));
        bw.newLine();
        if(num==1) {
            bw.write(Integer.toString(maxcountnum));
            bw.newLine();
        }else {
            bw.write(Integer.toString(fre2));
            bw.newLine();
        }
        bw.write(Integer.toString(maxloc-minloc));
        bw.newLine();
        bw.close();

    }

}
