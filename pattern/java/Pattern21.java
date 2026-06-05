import java.util.Scanner;

public class Pattern21 {

    public void printPattern(int N) {
        for (int i = 0; i < N; i++) {

            // Stars
            for (int j = 0; j <N; j++) {
                if(i ==0 || j==0 || i == N-1 || j == N-1)
                System.out.print("*");
                else
                System.out.print(" ");
            }
           
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern21 pattern = new Pattern21();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
