import java.util.Scanner;

public class Pattern8 {

 public void printPattern(int N) {
        for (int i = 0; i < N; i++) {
            // Space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // Start
            // Calculate the number of stars to print
            // int numStars = 2 * (N - i) - 1;
            int numStars = 2 * N  - (2*i+1);
            for (int j = 0; j <numStars; j++) {
                System.out.print("*");
            }
            // Space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println("");
        }

    }


    public static void main(String[] args) {
        Pattern8 pattern = new Pattern8();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
