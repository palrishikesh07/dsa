import java.util.Scanner;

public class Pattern20 {

    public static void main(String[] args) {
        Pattern20_1 pattern1 = new Pattern20_1();
        Pattern20_2 pattern2 = new Pattern20_2();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern1.printPattern(N);
        pattern2.printPattern(N);
        sc.close();
    }
}
