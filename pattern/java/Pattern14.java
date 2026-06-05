import java.util.Scanner;

public class Pattern14 {

    public void printPattern(int N) {
        for (int i = 0; i < N; i++) {

            for(char ch = 'A'; ch <='A'+i; ch++){
                System.out.print(ch+ " ");
            }
          
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern14 pattern = new Pattern14();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
