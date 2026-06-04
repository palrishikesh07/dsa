import java.util.Scanner;

public class Pattern4 {

    public void printPattern(int N) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Pattern4 pattern  = new Pattern4();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
    }
}
