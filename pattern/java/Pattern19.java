import java.util.Scanner;

public class Pattern19 {


    public static void main(String[] args) {
        Pattern19_1 pattern1 = new Pattern19_1();
        Pattern19_2 pattern2 = new Pattern19_2();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern1.printPattern(N);
        pattern2.printPattern(N);
        sc.close();
    }
}
