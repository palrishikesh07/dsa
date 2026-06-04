import java.util.Scanner;

public class Pattern6 {

    public void printPattern(int N) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N-i+1; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Pattern6 pattern  = new Pattern6();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
    }
}
