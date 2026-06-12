import java.util.Scanner;

class PrintNumberReverse {

    public static void printRecursiveNumberReverse(int n) {
        if (n<1) {
            return;
        }
        System.out.println(n);
        printRecursiveNumberReverse(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        printRecursiveNumberReverse(n);
    }
}