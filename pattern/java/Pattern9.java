import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        Pattern7 pattern7 = new Pattern7();
        Pattern8 pattern8 = new Pattern8();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern7.printPattern(N);
        pattern8.printPattern(N);
        sc.close();
    }
}
