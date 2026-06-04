import java.util.Scanner;

public class Pattern5 {

    public void printPattern(int N) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N-i+1; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Pattern5 pattern  = new Pattern5();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
    }
}
