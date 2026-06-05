import java.util.Scanner;

public class Pattern20_2 {

    public void printPattern(int N) {
        for (int i = 0; i < N; i++) {

            // Stars
            for (int j = 0; j < N-i-1; j++) {
                System.out.print("*");
            }
            // Space
            for (int j = 0; j < 2*i +2; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 0; j < N-i-1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern20_2 pattern = new Pattern20_2();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
