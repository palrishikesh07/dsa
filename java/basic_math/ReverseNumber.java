
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 12345;
        int reversed = reverseNumber(number);
        System.out.println("Reversed number of " + number + " is: " + reversed);
    }

    public static int reverseNumber(int num) {
        int reversedNumber= 0;
        while (num > 0) {
            int ld = num % 10;
            reversedNumber  = (reversedNumber * 10) +ld;
            num = num/10;
        }
        return reversedNumber;
    }
}
