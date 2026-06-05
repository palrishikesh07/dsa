import java.util.Scanner;

public class Pattern19_1 {

    public void printPattern(int N) {
        for (int i = 0; i < N; i++) {

            // Start
            for(int j=0;j< N-i; j++){
                System.out.print("*");
            }
            // Space
             for(int j=0;j< 2*i; j++){
                System.out.print(" ");
            }
             // Start
            for(int j=0;j< N-i; j++){
                System.out.print("*");
            }
            
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern19_1 pattern = new Pattern19_1();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
