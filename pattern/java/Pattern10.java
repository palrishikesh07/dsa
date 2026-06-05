import java.util.Scanner;

public class Pattern10 {

 public void printPattern(int N) {
        for (int i = 0; i <=2*N -1; i++) {
            // Space
            int start = i < N ? i: 2 * N - i;;
           
            for (int j = 0; j < start; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }


    public static void main(String[] args) {
        Pattern10 pattern = new Pattern10();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
