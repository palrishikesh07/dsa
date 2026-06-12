import java.util.Scanner;

public class SumParameterize {
     public static void sumRec(int n,int sum) {
        if (n<0) {
            System.err.println("Sum: "+sum);
            return;
        }
        sumRec(n-1,sum+n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sumRec(n,0);
    }
}
