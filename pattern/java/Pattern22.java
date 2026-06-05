import java.util.Scanner;

public class Pattern22 {

    public void printPattern(int N) {
        for (int i = 0; i < 2* N -1; i++) {
            
            for(int j=0; j< 2*N -1; j++){

                int top = i;
                int left = j;
                int bottom = (2* N-2) -i;
                int right = (2* N-2) -j;

                int minDist = Math.min(Math.min(top, bottom), Math.min(left, right));
                System.out.print((N-minDist + " "));
                // System.out.print((i + " "));
                // System.out.print((j + " "));
                // System.out.print((bottom + " "));
                // System.out.print((right + " "));

            }
           
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Pattern22 pattern = new Pattern22();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
