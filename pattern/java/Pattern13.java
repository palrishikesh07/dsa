import java.util.Scanner;

public class Pattern13 {

    public void printPattern(int N) {
        int counter = 1;
        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(counter+" ");
                counter = counter + 1;
            }
          
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern13 pattern = new Pattern13();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
