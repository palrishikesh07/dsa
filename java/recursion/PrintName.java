import java.util.Scanner;

class PrintName {

    public static void printRecursiveName(int i,int n) {
        if (i > n) {
            return;
        }
        System.out.println("Rishikesh Pal");
        printRecursiveName(i+1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        printRecursiveName(1,n);
    }
}