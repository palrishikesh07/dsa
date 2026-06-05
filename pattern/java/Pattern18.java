import java.util.Scanner;

public class Pattern18 {

    public void printPattern(int N) {
        for (int i = 0; i < N; i++) {

            for (char ch = (char) ('E' - i); ch <= 'E'; ch++) {
                System.out.print(ch);
            }

            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern18 pattern = new Pattern18();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
