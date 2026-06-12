import java.util.Scanner;

class PrintNumberBackTracking {

    public static void printNumberBackTrackingReverse(int n) {
        if (n < 0) {
            return;
        }
        printNumberBackTrackingReverse(n-1);
        System.out.println(n); // Output will display while reverse forms
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        printNumberBackTrackingReverse(n);
    }
}