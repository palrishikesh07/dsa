import java.util.Scanner;

class PrintNumber {

    public static void printRecursiveNumber(int i,int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        printRecursiveNumber(i+1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        printRecursiveNumber(1,n);
    }
}