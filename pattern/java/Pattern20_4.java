import java.util.Scanner;

public class Pattern20_4 {

    public void printPattern(int N) {
        int spaces = 2 * N - 2;
        for (int i = 1; i < 2 * N - 1; i++) {

            // Stars
            int stars = i;
            if (i > N)
                stars = 2 * N - i;
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            // Space
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println("");
            if (i < N)
                spaces -= 2;
            else
                spaces += 2;
        }

    }

    public static void main(String[] args) {
        Pattern20_4 pattern = new Pattern20_4();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
