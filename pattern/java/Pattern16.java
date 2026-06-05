import java.util.Scanner;

public class Pattern16 {

    public void printPattern(int N) {
        for (int i = 0; i < N; i++) {

            char ch = (char) ('A' + i);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern16 pattern = new Pattern16();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
