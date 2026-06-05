import java.util.Scanner;

public class Pattern11 {

 public void printPattern(int N) {
        int start = 1;
        for (int i = 0; i < N; i++) {
           if(i%2 == 0){
             start = 1;
           }
           else{
            start = 0;
           }
           for(int j=0; j<=i; j++){
                System.out.print(start+ " ");
                start = 1 - start; // Overwrite 0 and 1
           }    
            System.out.println("");
        }

    }


    public static void main(String[] args) {
        Pattern11 pattern = new Pattern11();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pattern.printPattern(N);
        sc.close();
    }
}
