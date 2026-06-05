import java.util.Scanner;

public class Pattern15 {

    public void printPattern(int N) {
        for (int i = N-1; i >=0; i--) {

            // for (int j = 1; j <= i; j++) {
            // System.out.print(j);
            // }
            for (char ch = 'A'; ch <= 'A' + i; ch++) {
                System.out.print(ch + " ");
            }

            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern15 pattern = new Pattern15();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
