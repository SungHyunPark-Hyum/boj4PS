import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
    // from에 꽂혀있는 num개의 원반을 by를 거쳐 to로 이동한다.
    public static void moveHanoiTower(int num, int from, int by, int to) {
// 이동할 원반의 수가 1개라면?
        if(num == 1) {
            System.out.println("원반" + num + "을 " + from + "에서 " + to +"로 이동");
        } else {
            // STEP 1 : num-1개를 A에서 B로 이동
            moveHanoiTower(num-1, from, to, by);
            // STEP 2 : 1개를 A에서 C로 이동
            System.out.println("원반" + num + "을 " + from + "에서 " + to +"로 이동");
            // STEP 3 : num-1개를 B에서 C로 이동
            moveHanoiTower(num-1, by, from, to);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        moveHanoiTower(N, 1, 2, 3);
    }

}
