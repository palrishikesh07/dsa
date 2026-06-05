import java.util.Scanner;

public class Pattern17 {

    public void printPattern(int N) {
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }
            char ch = 'A';
            int breakPoint = (2 * i + 1) / 2;
            // System.out.println("breakPoint: " + breakPoint);

            for (int j = 1; j <= 2*i + 1; j++) {
                System.out.print(ch);
                if (j <= breakPoint) {
                    ch++;
                } else {
                    ch--;
                }
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern17 pattern = new Pattern17();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
